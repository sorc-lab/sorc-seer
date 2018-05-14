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
	public static final String TT_FILE_EXT = "_meaning_tt.txt";

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
			String ATAFilePath = ATA_DIR + "/" + folderName;
			File ATAFolder = new File(ATAFilePath);
			File[] ATAFiles = ATAFolder.listFiles();
			String expectedATAFileName = folderName
					.toLowerCase() + ATA_FILE_EXT;
			
			String ATAData;

			// find data file and store it
			for (File ATAFile : ATAFiles) {
				String ATAFileName = ATAFile.getName();
				

				if (ATAFileName.equals(expectedATAFileName))
					ATAData = _readAllBytes(ATAFilePath + "/" + ATAFileName);
			}

			String TTFilePath = TT_DIR + "/" + folderName + "_Meaning";
			File TTFolder = new File(TTFilePath);
			File[] TTFiles = TTFolder.listFiles();
			String expectedTTFileName = folderName
					.toLowerCase() + TT_FILE_EXT;
			
			String expectedTTImageName = folderName
					.replace("_", "-")
					.toLowerCase() + ".png";
			
			String TTData;
			File TTImage;

			// find data and image files and store them separately
			for (File TTFile : TTFiles) {
				String TTFileName = TTFile.getName();
				
				if (TTFileName.equals(expectedTTFileName)) {
					TTData = _readAllBytes(TTFilePath + "/" + TTFileName);
				} else if (TTFileName.equals(expectedTTImageName)) {
					TTImage = new File(TTFilePath + TTFile);
				}
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
