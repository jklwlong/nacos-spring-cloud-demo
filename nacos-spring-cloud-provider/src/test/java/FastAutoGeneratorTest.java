import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

/**
 * @author liuwl
 * @since 2022/1/5
 */
public class FastAutoGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:mysql://192.168.23.239:3306/s1", "root", "");

    /**
     * 执行 run
     */
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir")+"\\nacos-spring-cloud-provider";
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder -> builder.author("liuwl")
                        .outputDir(projectPath + "/src/main/java")
                        .dateType(DateType.ONLY_DATE)
                        .disableOpenDir()
                        .fileOverride())
                // 包配置
                .packageConfig(builder -> builder.parent("com.example")
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "/src/main/resources/mapper"))
                        .entity("domain")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                        .xml("mapper.xml")
                        .controller("controller")
//                        .other("request")
                )
                // 模板配置
//                .templateConfig(builder -> builder
////                                .controller("/templates/controller1.java")
////                        .entity("/templates/entity1.java")
////                        .service("/templates/service1.java")
////                        .serviceImpl("/templates/serviceImpl1.java")
////                        .mapper("/templates/mapper.java")
////                        .mapperXml("/templates/mapper.xml")
//                        // 禁用
//                        .disable(TemplateType.CONTROLLER, TemplateType.SERVICEIMPL, TemplateType.MAPPER, TemplateType.SERVICE)
//                )
                // other 自定义文件输出
//                .injectionConfig(builder -> builder.customFile(new HashMap<String, String>() {{
//                            put("Req.java", "/templates/request1.java.vm");
//                        }})
//                )
                // 策略配置
                .strategyConfig(builder -> builder.addInclude("stock")
                        .entityBuilder()
                        .enableLombok()
                        .enableActiveRecord()
//                        .addTableFills(new Column("create_user", FieldFill.INSERT))
//                        .addTableFills(new Column("update_user", FieldFill.INSERT_UPDATE))
//                        .addTableFills(new Column("create_time", FieldFill.INSERT))
//                        .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                        .controllerBuilder()
//                        .superClass(BaseController.class)
                        .enableRestStyle()
                        .mapperBuilder()
                        .enableBaseResultMap()
                        .enableBaseColumnList()
                )
                // 模板引擎配置Velocity
                .templateEngine(new VelocityTemplateEngine() {
//                                    @Override
//                                    protected void outputCustomFile(Map<String, String> customFile, TableInfo tableInfo, Map<String, Object> objectMap) {
//                                        String entityName = tableInfo.getEntityName();
//                                        String otherPath = this.getPathInfo(OutputFile.other);
//                                        customFile.forEach((key, value) -> {
//                                            String fileName = String.format(otherPath + File.separator + "%s", entityName + "Req.java");
//                                            outputFile(new File(fileName), objectMap, value);
//                                        });
//                                    }
                                }
                )
                .execute();
    }

//    /**
//     * 执行初始化数据库脚本
//     */
//    public static void before() throws SQLException {
//        Connection conn = DATA_SOURCE_CONFIG.build().getConn();
//        InputStream inputStream = H2CodeGeneratorTest.class.getResourceAsStream("/sql/init.sql");
//        ScriptRunner scriptRunner = new ScriptRunner(conn);
//        scriptRunner.setAutoCommit(true);
//        scriptRunner.runScript(new InputStreamReader(inputStream));
//        conn.close();
//    }
}
