package com.nhnacademy.regexdemo;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ApacheCommonsCLi {
    public static void main(String[] args) throws ParseException {
        Options options = new Options();

        Option classPath = Option.builder("classpath")
                .longOpt("class-Path")
                .hasArg()
                .desc("Class Path")
                .build();

        Option module = Option.builder("m")
                .longOpt("module")
                .hasArg()
                .desc("Modules")
                .build();

        Option group = Option.builder("g")
                .desc("Global")
                .build();

        Option version = Option.builder("v")
                .longOpt("Version")
                .desc("Version")
                .build();

        Option help = Option.builder("h")
                .longOpt("help")
                .desc("help")
                .build();

        options.addOption(classPath);
        options.addOption(module);
        options.addOption(group);
        options.addOption(version);
        options.addOption(help);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("ls", options);
            System.exit(0);
        }
        if (cmd.hasOption("v")) {
            System.out.println("Version: 1.0.0");
            System.exit(0);
        }

        if (cmd.hasOption(classPath.getOpt())) {
            String classPathValue = cmd.getOptionValue(classPath.getOpt());
            System.out.println("Class Path: " + classPathValue);
        }

        if (cmd.hasOption(module.getOpt())) {
            System.out.println("Module: ");
        }

        if (cmd.hasOption(module.getOpt())) {
            System.out.println("Group: ");
        }

        System.out.println(cmd.getArgList());
    }

    // apache commaned Cli user부분 보기
}
