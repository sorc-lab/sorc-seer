package seer;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import seer.ata.ATAGetData;
import seer.ata.ATAHarvester;
import seer.ata.ATASetup;
import seer.tt.TTHarvester;
import seer.tt.TTSetup;

public class Main {
	public static final String ATA_DIR = "ATATarot";
	public static final String ATA_FILE_EXT = "_ata.txt";
	public static final String TT_DIR = "TTTarot";
	public static final String TT_FILE_EXT = "_tt.txt";

	public static void main(String[] args) throws Exception {
		WebDriver driver = new PhantomDriver().getPhantomDriver();
		_tearDown();

		/*
		 * Setup setupATA = new ATASetup(driver); setupATA.setupHarvester();
		 * ATAHarvester ATAHarvester = new ATAHarvester(driver);
		 * ATAHarvester.harvest();
		 */

		/*
		 * Setup setupTT = new TTSetup(driver); setupTT.setupHarvester();
		 * TTHarvester TTHarvester = new TTHarvester(driver);
		 * TTHarvester.harvest();
		 */
	}

	private static void _tearDown() {
		List<String> folders = _findFoldersInDirectory(ATA_DIR);
		for (String folderName : folders) {
			// folder contains data needed for _readAllBytes
			// folder contains the same file name as TT dir filenames
			// make new file /w same file name, minus the "_ata"
			// write TT data to it, then append the ATA data to it
			// copy over the .png

			String ATAFilePath = ATA_DIR + "/" + folderName;
			File ATAFolder = new File(ATAFilePath);
			File[] ATAFiles = ATAFolder.listFiles();

			// store ATAData
			for (File ATAFile : ATAFiles) {
				String ATAFileName = ATAFile.getName();
				String expectedATAFileName = folderName
						.toLowerCase() + ATA_FILE_EXT;

				String ATAData;

				if (ATAFileName.equals(expectedATAFileName))
					ATAData = _readAllBytes(ATAFilePath + "/" + ATAFileName);
			}

			String TTFilePath = TT_DIR + "/" + folderName + "_Meaning";
			File TTFolder = new File(TTFilePath);
			File[] TTFiles = TTFolder.listFiles();

			for (File TTFile : TTFiles) {
				System.out.println(TTFile.getName());
			}
		}
	}

	private static String _readAllBytes(String filePath) {
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	private static List<String> _findFoldersInDirectory(String directoryPath) {
		File directory = new File(directoryPath);

		FileFilter directoryFileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		File[] directoryListAsFile = directory.listFiles(directoryFileFilter);
		ArrayList<String> foldersInDirectory = new ArrayList<String>(
				directoryListAsFile.length);
		
		for (File directoryAsFile : directoryListAsFile) {
			foldersInDirectory.add(directoryAsFile.getName());
		}

		return foldersInDirectory;
	}
}
