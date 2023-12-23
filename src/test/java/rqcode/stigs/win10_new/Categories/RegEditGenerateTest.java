package rqcode.stigs.win10_new.Categories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class RegEditGenerateTest {

    @Test
    public void generateRegEdits() throws IOException {
        // Initialize the Velocity engine
        VelocityEngine velocityEngine = new VelocityEngine();
        ObjectMapper mapper = new ObjectMapper();

        Properties props = new Properties();
        props.put(RuntimeConstants.RESOURCE_LOADER, "file,class,classpath");
        props.put("file.resource.loader.path", "classpath");
        props.put("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        velocityEngine.init(props);

        String content = Files.readString(Path.of("src/test/resources/templates/regEdit/regedit.json"), StandardCharsets.UTF_8);
        List<RegEditTemplate> regEditTemplates = new ArrayList<>();

        regEditTemplates = Arrays.asList(mapper.readValue(content, RegEditTemplate[].class));

        // Load the template
        Template template = velocityEngine.getTemplate("templates/regEdit/RegEditTemplate.vm");

        for (RegEditTemplate regEditTemplate : regEditTemplates) {
            VelocityContext context = new VelocityContext();
            context.put("id", regEditTemplate.getId());
            context.put("path", regEditTemplate.getPath());
            context.put("path_short", regEditTemplate.getPath_short());
            context.put("attr", regEditTemplate.getAttr());
            context.put("result_value", regEditTemplate.getResult_value());
            context.put("description", regEditTemplate.getDescription());

            // Generate the Java code
            StringWriter writer = new StringWriter();
            template.merge(context, writer);

            Files.write( Paths.get("src/main/java/rqcode/stigs/win10_new/RegistryEdit/stigs/" + regEditTemplate.getId() + ".java"), writer.toString().getBytes());
        }
    }

    @Test
    public void generateRegEditsScripts() throws IOException {
        // Initialize the Velocity engine
        VelocityEngine velocityEngine = new VelocityEngine();
        ObjectMapper mapper = new ObjectMapper();

        Properties props = new Properties();
        props.put(RuntimeConstants.RESOURCE_LOADER, "file,class,classpath");
        props.put("file.resource.loader.path", "classpath");
        props.put("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        velocityEngine.init(props);

        String content = Files.readString(Path.of("src/test/resources/templates/regEdit/regedit.json"), StandardCharsets.UTF_8);
        List<RegEditTemplate> regEditTemplates = new ArrayList<>();

        regEditTemplates = Arrays.asList(mapper.readValue(content, RegEditTemplate[].class));

        // Load the template
        Template template = velocityEngine.getTemplate("templates/regEdit/RegEditTemplateScriptCheck.vm");

        for (RegEditTemplate regEditTemplate : regEditTemplates) {
            VelocityContext context = new VelocityContext();
            context.put("id", regEditTemplate.getId());
            context.put("path", regEditTemplate.getPath());
            context.put("path_short", regEditTemplate.getPath_short());
            context.put("attr", regEditTemplate.getAttr());
            context.put("result_value", regEditTemplate.getResult_value());

            // Generate the Scripts
            StringWriter writer = new StringWriter();
            template.merge(context, writer);

            Files.write( Paths.get("src/main/java/rqcode/stigs/win10_new/RegistryEdit/scriptsCheck/" + regEditTemplate.getId() + ".ps1"), writer.toString().getBytes());
        }
    }
}