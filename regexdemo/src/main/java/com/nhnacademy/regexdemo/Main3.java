package com.nhnacademy.regexdemo;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main3 {

    public static void main(String args[]) throws ParseException {
        Options options = new Options();

        options.addOption("t", false, "display current time");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("t")) {
            // print the date and time
        } else {
            // print the date
        }

        // final Options options = new Options();
        // options.addOption(new Option("d", "debug", false, "Turn on debug."));
        // options.addOption(new Option("e", "extract", false, "Turn on extract."));
        // options.addOption(new Option("o", "option", true, "Turn on option with argument."));

    }

}
