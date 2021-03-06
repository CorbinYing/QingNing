package com.xiesu.mybatiesgenerator;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * xiesu
 */
@Component
public class Config implements CommandLineRunner {

    private final Environment environment;

    private static String url;
    private static String username;
    private static String pwd;
    private static List<String> tables;

    private static String tablePrefix;

    private static String tableSuffix;

    private static String author;
    private static String outputDir;


    private static String project_name;

    private static String group_id;

    private static String artifact_id;

    private static String super_entity;
    private static List<String> super_entity_columns;

    private static String super_controller;


    public void before() {
        url = environment.getProperty("generate.datasource.url");
        username = environment.getProperty("generate.datasource.username");
        pwd = environment.getProperty("generate.datasource.pwd");
        tables = Arrays.stream(
                Objects.requireNonNull(environment.getProperty("generate.datasource.tables"))
                        .split(",")).collect(Collectors.toList());
        tablePrefix = environment.getProperty("generate.datasource.table_prefix");
        tableSuffix = environment.getProperty("generate.datasource.table-suffix");
        author = environment.getProperty("generate.author");
        outputDir = environment.getProperty("generate.project.output-dir");
        project_name = environment.getProperty("generate.project.project-name");
        group_id = Objects.requireNonNull(environment.getProperty("generate.project.group-id"));
        artifact_id = Objects.requireNonNull(
                environment.getProperty("generate.project.artifact-id"));
        super_entity = environment.getProperty("generate.project.entity.super-entity");
        super_entity_columns = Arrays.stream(Objects.requireNonNull(
                        environment.getProperty("generate.project.entity.super-entity-columns")).split(","))
                .collect(Collectors.toList());
        super_controller = environment.getProperty("generate.project.controller.super-controller");


    }


    @Override
    public void run(String... args) throws Exception {
        before();

        String basePath = outputDir + project_name;
        FastAutoGenerator.create(url, username, pwd).globalConfig(builder -> {

                    builder.author(author) // ????????????
                            //.enableSwagger() // ?????? swagger ??????
                            .fileOverride() // ?????????????????????
                            .outputDir(basePath + "/src/main/java"); // ??????????????????
                }).packageConfig(builder -> {
                    builder.parent(group_id.replace("-", "")) // ???????????????
                            .moduleName(artifact_id.replace("-", "")) // ?????????????????????
                            .entity("entity").service("service").serviceImpl("service.impl")
                            .controller("controller").mapper("mapper").xml("mapper").pathInfo(
                                    Collections.singletonMap(OutputFile.xml,
                                            basePath + "/src/main/resources/mapper/")); // ??????mapperXml????????????
                })

                .strategyConfig(builder -> {
                    // 	?????????????????????(????????????)???	include ??? exclude ??????????????????
                    builder.addInclude(tables)
                            // 	?????????????????????
                            .addTableSuffix(tableSuffix)
                            // 	?????????????????????
                            .addTablePrefix(tablePrefix)
                            // service ????????????
                            .serviceBuilder()
                            // 	?????????????????????
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")

                            // ??????????????????
                            .entityBuilder()
                            // ?????? lombok ??????
                            .enableLombok()
                            // ???????????????????????????????????????
                            .enableTableFieldAnnotation().superClass(super_entity)
                            .addSuperEntityColumns(super_entity_columns)

                            // controller ????????????
                            .controllerBuilder().formatFileName("%sController")
                            // ????????????@RestController ?????????
                            .enableRestStyle()
                            //?????????????????????
                            .enableHyphenStyle().superClass(super_controller)

                            // 	mapper ????????????
                            .mapperBuilder()
                            // ????????????
                            .superClass(BaseMapper.class).enableBaseResultMap()
                            .formatMapperFileName("%sMapper").enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");
                })
//                .templateEngine(new VelocityTemplateEngine())
                .templateEngine(new FreemarkerTemplateEngine()) // ??????Freemarker???????????????????????????Velocity????????????
                .execute();

    }


    public Config(Environment env) {
        this.environment = env;
    }
}
