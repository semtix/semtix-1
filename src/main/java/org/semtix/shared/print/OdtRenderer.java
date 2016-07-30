package org.semtix.shared.print;

import org.semtix.shared.daten.ArrayHelper;

import java.io.IOException;

import static org.semtix.config.SettingsExternal.PDF_PATH;

public class OdtRenderer {

    /*
     * Hier wird ein odt Dokument in eine PDF konvertiert und im ausgabepfad
     * gespeichert. Besonders nützlich für große Druckauftraege wie beim
     * Bescheide-Druck.
     *
     * Created by FS on 26.06.2016
    /*

     /*
     * Renders one file as pdf
     *
     * @param path file location
     * @throws IOException Dateizugrifffehler
     */
    public static void print(String path) throws IOException {
        printFiles(new String[]{path});
        }


    /**
     * Renders file with soffic bin. Ignores lock and does not display splash screen
     * Default output path is CWD if OUT_PATH=null
     *
     * @param pathnames space separated list of absolute filepaths that are to be rendered
     * @throws IOException Dateizugrifffehler
     */
    public static void printFiles(String[] pathnames) throws IOException {


        String[] wholeCommand = ArrayHelper.concatenate(new String[]{"soffice", "--headless", "--nolockcheck", "--convert-to", "pdf", "--outdir", PDF_PATH}, pathnames);

        wholeCommand = ArrayHelper.concatenate(wholeCommand, new String[]{" &"});

        Runtime.getRuntime().exec(wholeCommand);

    }
}
