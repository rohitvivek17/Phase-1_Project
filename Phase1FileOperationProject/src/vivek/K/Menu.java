package vivek.K;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private Scanner sc;
	Menu()
	{
		sc=new Scanner(System.in);
	}
	public void details(String appName,String devName)
	{
		
		System.out.println("\n\n\t======================App Details and Developer Name=========================");
		System.out.println("\n\t\t AppName       : "+appName);
		System.out.println("\n\t\t DeveloperName : "+devName);
		System.out.println("====================================================================================");
		System.out.print(" Type Ok and Press Enter key to continue...........");
		String s=sc.next();
	}
	public void mainMenu()
	{
		System.out.print("\n\n\n\t======================= Welcome to Main Menu=====================================");
		System.out.print("\n\n\t 1-> for Display All From Main Directory ");
		System.out.print("\n\n\t 2-> for Display All the Files from Other Directory ");
		System.out.print("\n\n\t 3->for File Operation ");
		System.out.print("\n\n\t 4-> for Exit the program ");
		
	}
	public void fileMenu()
	{
		
		System.out.print("\n\n\t======================== Welcome to File Operation Menu==============================");
		System.out.print("\n\n\t 1-> for Add File with Content ");
		System.out.print("\n\n\t 2-> For Delete the File ");
		System.out.print("\n\n\t 3-> For Search the File");
		System.out.print("\n\n\t 4-> for Go Back to Main Menu ");
	}
	

	//Function with Main Menu
	public void mainTask()
	{
		
		sc=new Scanner(System.in);
		int ch=1;
		while(ch!=4)
		{
			try
			{
				
					mainMenu();
					System.out.print("\n\n\tEnter the choice");
					ch=sc.nextInt();
					switch(ch)
					{
						case 1:
							fileDisplayInAscendingOrder(true);
							pause();
							break;
						case 2:
							fileDisplayInAscendingOrder(false);
							pause();
						case 3:
							fileTask();
						break;
						case 4:
							displayMessage();
						break;
					
						default:
							System.out.print("\n\n\t Sorry !! You have Selected Wrong  Choice ");
							pause();
							
					}
					
				
				
			}catch(InputMismatchException e)
			{
				System.out.print("\n\n\t Sorry Only Integer Numbers are Allowed");
				pause();
			}
			catch(Exception e)
			{
				System.out.print("Error Created ="+e.toString());
			
			}
		}
		System.gc();
	}
	
	public  void fileDisplayInAscendingOrder(boolean f) {
		
	sc=new Scanner(System.in);
		String path="__main__";
		CreateDirectoryIfNotExist();
		if(!f)
		{
		
		System.out.print("Enter the Path that List you have to See  ");
		path=sc.nextLine();
		}
		
		List<String> filesName=new ArrayList<>();
		System.out.print("\n\n\t ================ File/Folder Structure Given Below================================\n\n\n");
		List<String> totalFileName=displayAllFiles(path,3,filesName);
		System.out.print("\n\n\t==============================End of Location=======================================");
		System.out.println("\n\n\t\t************ Files in Give Location *************");
		Collections.sort(totalFileName);
		int i=0;
		totalFileName.forEach(n->{
			System.out.println("\t\t ->"+n);
		
		});
		System.out.println("\n\n\t=================================End of File Names=============");
		System.gc();
	}
	public  void fileTask() 
	{
		
		int ch=1;
		 sc=new Scanner(System.in);
		try
		{
			while(ch!=4)
			{
				fileMenu();
				System.out.print("\n\n\t Enter the choice");
				ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					fileCreation();
					pause();
					break;
				case 2:
					fileDeletion();
					pause();
					break;
				case 3:
					fileSearching();
					pause();
					break;
				case 4:
				break;
				default:
					System.out.print("\n\n\t Sorry !! You have Selected Wrong  Choice ");
					pause();
					
				}
				
			}
		
			
		}catch(InputMismatchException e)
		{
			System.out.print("\n\n\t Sorry Only Integer Numbers are Allowed");
			System.out.print("\n\n\tType Ok and press Enter key to Continue...........");
			String s=sc.next();
		}
		catch(Exception e)
		{
			System.out.print("Error Created ="+e.toString());
		
		}
		System.gc();
	}
	private void CreateDirectoryIfNotExist()
	{
		File f=new File("__main__");
		if(!f.exists())
			f.mkdir();
	}
	private void fileCreation()
	{
		CreateDirectoryIfNotExist();
		
		 sc=new Scanner(System.in);
		try
		{
			
			String file="";
			System.out.print("Enter the file name");
			file=sc.nextLine();
			String path="__main__//"+file;
			File f=new File(path);
			if(!f.exists())
				f.createNewFile();
			int i=0;
			System.out.print("enter the number of lines you want to add ");
			i=sc.nextInt();
			String line="";
			System.out.print("Enter your text ");
			while(i>0)
			{
				line+=sc.nextLine()+"\n";
				i--;
			}
			FileOutputStream fout=new FileOutputStream(f,true);
			byte[] c=line.getBytes();
			fout.write(c);
			
			
			
		
		} catch (IOException e) {
				// TODO Auto-generated catch block
			System.out.println("hello i am ");
				e.printStackTrace();
		}
			
		System.gc();
	}
	private void fileDeletion()
	{
		System.out.print("\n\n\t===============Welcome to File Deletion Module=======================");
		System.out.print("\n\n\t 1-> for Main Directory");
		System.out.print("\n\n\t 2-> for Other Location");
		System.out.print("\n\n\t Enter the choice ");
		sc=new Scanner(System.in);
		int i;
		i=sc.nextInt();
		switch(i)
		{
		case 1:
			getFileDeleted(true);
		break;
		case 2:
			getFileDeleted(false);
		break;
		default:
			System.out.println(" Sorry!! Wrong Option selected\n\t Try Again");
			
		}
		
		
	}
	private void getFileDeleted(boolean b) {
		String path="__main__";
		sc=new Scanner(System.in);
		if(!b)
		{
			System.out.print("Enter the new Location from there File will be deleted");
			path=sc.nextLine();
		}
		String filename="";
		System.out.print("Enter the file name that will be deleted");
		filename=sc.next();
		File f=new File(path);
		File files[]=f.listFiles();
		List<File> listFile=Arrays.asList(files);
		int flag=0;
		Iterator<File> fn =listFile.iterator();
		while(fn.hasNext())
		{
			File tmp=fn.next();
			if(tmp.getName().equalsIgnoreCase(filename))
			{
				flag=1;
				System.out.println("File Found at"+f.getAbsolutePath());
				System.out.print("Are you sure to Delete Y/N" );
				String inp=sc.next();
				if(inp.equalsIgnoreCase("y"))
					tmp.delete();
				else
					flag=2;
				break;
			}
		}
		if(flag==1)
			System.out.println("\n\n\tFile Found and deleted Succesfuyly");
		else if(flag==2)
			System.out.print("\n\tOperation Aborted Successfully");
		else
			System.out.print("\n\tSorry! File not Found");
		
		
	}
	private void fileSearching()
	{
		System.out.print("\n\n\n========================Welcome To file Searching Option =============================");
		System.out.println("\n\n\t 1-> from Current Directory");
		System.out.println("\n\n\t 2-> from New Location");
		System.out.print("\n\n\t\t Enter your choice");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			filesearch(true);
			break;
		case 2:
			filesearch(false);
			break;
		default:
			System.out.print("\n\n\t Sorry!! Wrong choice Selected \n\tTry Again");
			
		}
		
	}
	private void filesearch(boolean b) {
		//from Existing Directory __main__ 
		sc=new Scanner(System.in);
		String path="__main__";
		
		// for new Location 
		if(!b)
		{
		System.out.print("Enter the Location: ");
		path=sc.nextLine();
		}
		String filename="";
		System.out.print("Enter the FileName : ");
		filename=sc.nextLine();
		int flag=0;
		List<String>listFilenames=new ArrayList<>();
		getFile(path,filename,listFilenames);
		
		Iterator it=listFilenames.listIterator();
		int i=0;
		System.out.println("\n\n======List of File Found at : "+path+" With Filename : "+filename+" is given below=================================");
		while(it.hasNext())
		{
			System.out.println("\n\n\t"+(++i)+" -> "+it.next());
		}
		System.out.print("\n\n\t===================================End of list================================");
		
		System.gc();
	}
	public void pause()
	{
		sc=new Scanner(System.in);
		System.out.print("\n\n\tType ok and Press Enter key to continue..................");
		String tmp=sc.next();
		System.gc();
	}
	public static void getFile(String path,String Filename,List<String> listFilenames)
	{
		File file=new File(path);
		File files[]=file.listFiles();
		
		
		if(files!=null && files.length>0 )
		{
			List<File> listFile=Arrays.asList(files);
			//Accessing of Files using Lambda Expression  
			listFile.forEach(n->{
				
				if(n.getName().toLowerCase().startsWith(Filename.toLowerCase()))
				{
					if(n.isFile())
					listFilenames.add(n.getAbsolutePath());
					else
						getFile(n.getAbsolutePath(), Filename, listFilenames);
					
				}
					else
				{
					if(n.isDirectory())
						getFile(n.getAbsolutePath(), Filename, listFilenames);
				}
				
			});
		}
	}
	public void displayMessage()
	{
		System.out.print("====================================== Thanks===============================");
		System.out.println("\n\n\t Thanks for Using This Software ");
		System.out.println("\n\n\t Special Thanks to My Trainer Mr. Mritunjay ");
		System.out.println("\n\tI am hearty Thanks to Simplilearn to make me able to complete this task");
		System.out.println("\n\tAt Last Thanks to Everyone ");
		System.out.println("\n\tDeveloper Name is Vikas Srivastava From Gorakhpur UP India");
		System.out.println("=============================================================================");
	}
	public  List<String>  displayAllFiles(String path,int indentationCount,List<String> listFileNames)
	{

		try
		{
		File file=new File(path);
		File files[]=file.listFiles();
		List<File> filenames=Arrays.asList(files);
		Collections.sort(filenames);
		if(files!=null && files.length>0)
		{
			for(File f:filenames)
			{
				
				System.out.print(" ".repeat(indentationCount * 2));
				if(f.isDirectory())
				{
					System.out.println("-->[Dir] "+f.getName());
					listFileNames.add(f.getName());
					displayAllFiles(f.getAbsolutePath(), indentationCount+1, listFileNames);
				}
				else
				{
					System.out.println("|-->[Files] "+f.getName());
					listFileNames.add(f.getName());
				}
				
				
			}
		}
		else
		{
			System.out.println(" ".repeat(indentationCount*2));
			System.out.println("--> Empty Directoryies ");
		}
		
		}catch(Exception e) {}
		return listFileNames;
	}
	
}
