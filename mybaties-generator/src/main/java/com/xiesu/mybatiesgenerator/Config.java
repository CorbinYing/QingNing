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


    public void before() {
        url = environment.getProperty("generate.datasource.url");
        username = environment.getProperty("generate.datasource.username");
        pwd = environment.getProperty("generate.datasource.pwd");
        tables = Arrays.stream(Objects.requireNonNull(environment.getProperty("generate.datasource.tables")).split(",")).collect(Collectors.toList());
        tablePrefix = environment.getProperty("generate.datasource.table_prefix");
        tableSuffix = environment.getProperty("generate.datasource.table-suffix");
        author = environment.getProperty("generate.author");
        outputDir = environment.getProperty("generate.project.output-dir");
        project_name = environment.getProperty("generate.project.project-name");
        group_id = environment.getProperty("generate.project.group-id");
        artifact_id = environment.getProperty("generate.project.artifact-id");
        super_entity = environment.getProperty("generate.project.entity.super-entity");
        super_entity_columns = Arrays.stream(Objects.requireNonNull(environment.getProperty("generate.project.entity.super-entity-columns")).split(",")).collect(Collectors.toList());


    }


    @Override
    public void run(String... args) throws Exception {
        before();

        String basePath = outputDir + project_name;
        FastAutoGenerator.create(url, username, pwd)
                .globalConfig(builder -> {

                    builder.author(author) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(basePath + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(group_id) // 设置父包名
                            .moduleName(artifact_id) // 设置父包模块名
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, basePath + "/src/main/resources/mapper/")); // 设置mapperXml生成路径
                })


                .strategyConfig(builder -> {
                    // 	增加表排除匹配(内存过滤)，	include 与 exclude 只能配置一项
                    builder.addInclude(tables)
                            // 	增加过滤表后缀
                            .addTableSuffix(tableSuffix)
                            // 	增加过滤表前缀
                            .addTablePrefix(tablePrefix)
                            // service 策略配置
                            .serviceBuilder()
                            // 	格式化文件名称
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")

                            // 实体策略配置
                            .entityBuilder()
                            // 开启 lombok 模型
                            .enableLombok()
                            // 开启生成实体时生成字段注解
                            .enableTableFieldAnnotation()
                            .superClass(super_entity)
                            .addSuperEntityColumns(super_entity_columns)


                            // controller 策略配置
                            .controllerBuilder()
                            .formatFileName("%sController")
                            // 开启生成@RestController 控制器
                            .enableRestStyle()


                            // 	mapper 策略配置
                            .mapperBuilder()
                            // 设置父类
                            .superClass(BaseMapper.class)
                            .enableBaseResultMap()
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");
                })
//                .templateEngine(new VelocityTemplateEngine())
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }


    public Config(Environment env) {
        this.environment = env;
    }
}
