package seer;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
	
	private static String _ATAData;
	private static String _TTData;

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

	// TODO: Refactor
	private static void _tearDown() throws IOException {
		List<String> folders = _findFoldersInDirectory(ATA_DIR);
		File ATAFolder = null;
		File TTFolder = null;
		
		for (String folderName : folders) {
			String ATAFilePath = ATA_DIR + "/" + folderName;
			ATAFolder = new File(ATAFilePath);
			File[] ATAFiles = ATAFolder.listFiles();
			String expectedATAFileName = folderName
					.toLowerCase() + ATA_FILE_EXT;

			// find data file and store it
			for (File ATAFile : ATAFiles) {
				String ATAFileName = ATAFile.getName();
				
				// read file into memory and delete from disc
				if (ATAFileName.equals(expectedATAFileName)) {
					_ATAData = _readAllBytes(ATAFilePath + "/" + ATAFileName);
					File ATADataFile = new File(
							ATAFilePath + "/" + ATAFileName);
					
					ATADataFile.delete();
				}
			}

			String TTFilePath = TT_DIR + "/" + folderName + "_Meaning";
			TTFolder = new File(TTFilePath);
			
			File[] TTFiles = TTFolder.listFiles();
			String expectedTTFileName = folderName
					.toLowerCase() + TT_FILE_EXT;
			
			String TTImageName = "";
			File TTImage = null;

			// find data and image files and store them separately
			for (File TTFile : TTFiles) {
				String TTFileName = TTFile.getName();
				
				if (TTFileName.equals(expectedTTFileName)) {
					_TTData = _readAllBytes(TTFilePath + "/" + TTFileName);
				} else if (TTFileName.contains(".png")) {
					TTImageName = TTFile.getName();
					TTImage = new File(TTFilePath + "/" + TTImageName);
				}
			}
			
			_combineData(folderName);
						
			// Copy .png file into dir.
			File destDir = new File(
					_getATAFilePath(folderName) + "/" + TTImageName);
			
			Path src = TTImage.toPath();
			Path dest = destDir.toPath();
			Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
		}
		
		File TTDir = new File(TT_DIR);
		FileUtils.forceDelete(TTDir);
		
		File ATADir = new File(ATA_DIR);
		File newDirName = new File("TarotData");
		ATADir.renameTo(newDirName);
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
	
	private static void _combineData(String folderName) {
		String newFilePath = _getATAFilePath(folderName);
		File newFile = new File( // _getNewFIlePath()
				newFilePath + "/" + folderName.toLowerCase() + ".txt");
		try {
			newFile.createNewFile();
			FileWriter writer = new FileWriter(newFile);
			writer.write(_TTData);
			writer.write("\n---\n\n");
			writer.write(_ATAData);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String _getATAFilePath(String folderName) {
		return ATA_DIR + "/" + folderName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
