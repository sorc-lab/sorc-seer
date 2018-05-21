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
	
	private static String _ATAFolderName;
	private static String _ATAData;
	private static String _TTData;
	private static File _TTImage;
	private static String _expectedATAFileName;
	private static File[] _ATAFiles;
	private static String _ATAFilePath;

	public static void main(String[] args) throws Exception {
		// TODO: _setup(Object Setup), use generics + make AbstractSetup
		Setup setupATA = new ATASetup();
		setupATA.setupHarvester();
		//ATAHarvester ATAHarvester = new ATAHarvester(driver);
		//ATAHarvester.harvest();

		/*
		Setup setupTT = new TTSetup(driver);
		setupTT.setupHarvester();
		TTHarvester TTHarvester = new TTHarvester(driver);
		TTHarvester.harvest();
		*/
		
		//_tearDown();
	}

	private static void _tearDown() throws IOException {
		List<String> folders = _findFoldersInDirectory(ATA_DIR);
		File ATAFolder = null;
		
		for (String ATAFolderName : folders) {
			_ATAFolderName = ATAFolderName;
			_ATAFilePath = ATA_DIR + "/" + _ATAFolderName;
			ATAFolder = new File(_ATAFilePath);
			_ATAFiles = ATAFolder.listFiles();
			_expectedATAFileName = _ATAFolderName
					.toLowerCase() + ATA_FILE_EXT;
			_setATADataAndDeleteFromDisc();
			_setTTDataAndTTImage();
			_combineData();
			_copyTTImage();
		}
		
		_deleteTTDir();
		_renameATADir("TarotData");
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
	
	private static void _combineData() {
		String newFilePath = _getATAFilePath();
		File newFile = new File(
				newFilePath + "/" + _ATAFolderName.toLowerCase() + ".txt");
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
	
	private static String _getATAFilePath() {
		return ATA_DIR + "/" + _ATAFolderName;
	}
	
	private static void _deleteTTDir() {
		try {
			File TTDir = new File(TT_DIR);
			FileUtils.forceDelete(TTDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void _renameATADir(String newName) {
		File ATADir = new File(ATA_DIR);
		File newDirName = new File(newName);
		ATADir.renameTo(newDirName);
	}
	
	private static void _copyTTImage() {
		File destDir = new File(
				_getATAFilePath() + "/" + _TTImage.getName());
		
		Path src = _TTImage.toPath();
		Path dest = destDir.toPath();
		
		try {
			Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void _setTTDataAndTTImage() {
		String TTFilePath = TT_DIR + "/" + _ATAFolderName + "_Meaning";
		File TTFolder = new File(TTFilePath);
		File[] TTFiles = TTFolder.listFiles();
		String expectedTTFileName = _ATAFolderName
				.toLowerCase() + TT_FILE_EXT;
		
		// find data and image files and store them separately
		for (File TTFile : TTFiles) {
			String TTFileName = TTFile.getName();
			
			if (TTFileName.equals(expectedTTFileName)) {
				_TTData = _readAllBytes(TTFilePath + "/" + TTFileName);
			} else if (TTFileName.contains(".png")) {
				_TTImage = new File(TTFilePath + "/" + TTFile.getName());
			}
		}
	}
	
	private static void _setATADataAndDeleteFromDisc() {
		// find data file and store it
		for (File ATAFile : _ATAFiles) {
			String ATAFileName = ATAFile.getName();
			
			// read file into memory and delete from disc
			if (ATAFileName.equals(_expectedATAFileName)) {
				_ATAData = _readAllBytes(_ATAFilePath + "/" + ATAFileName);
				File ATADataFile = new File(
						_ATAFilePath + "/" + ATAFileName);
				
				ATADataFile.delete();
			}
		}
	}
}
