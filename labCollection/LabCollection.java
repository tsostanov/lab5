package labCollection;

import client.ResultData;
import commands.CommandData;
import exceptions.IdIsNotUniqueException;
import exceptions.WrongInputException;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.InvalidPathException;
import java.time.LocalDateTime;
import java.util.*;
import java.time.format.*;
/**
 * LabCollection (or Server) stores and manages LabWorks.
 */
public class LabCollection {
    private static LinkedList<LabWork> labsList = new LinkedList<>();
    private  String filePath;
    private java.time.LocalDateTime creationDate;

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LabCollection(){
        this.creationDate = java.time.LocalDateTime.now();
    }
    public LinkedList<LabWork> getCollection(){
        return labsList;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ResultData execute(CommandData commandData){
        return commandData.command.execute(commandData);
    }
    public static LinkedList<LabWork> getLabList(){
        return labsList;
    }
    public static void updateLab(LinkedList<LabWork> labList){
        labsList = labList;
    }

    public ResultData info(){
        ResultData resultData = new ResultData();
        resultData.resultText = ServerTextFormer.collectionInfo(this);
        return resultData;
    }

    public ResultData readCSVFile(){
        ResultData resultData = new ResultData();
        try{
            LinkedList<LabWork> labWorks = (LinkedList<LabWork>) CSVHandler.readCSV(filePath);
            checkIdUnique(labWorks);
            setIdPointerToMaxId(labWorks);
            labsList.addAll(labWorks);
        }
        catch (WrongInputException e){
            resultData.resultText = e.toString();
        }
        catch (NumberFormatException e){
            String str = "CSV number format exception:\n" + e.getMessage();
            resultData.errorMessage = str;
        }
        catch (NoSuchElementException e){
            String str = "CSV has not enough data\n" + e.getMessage() + e.getLocalizedMessage();
            resultData.errorMessage = str;
        }
        catch(DateTimeParseException e){
            String str = "CSV date format exception:\n" + e.getMessage();
            resultData.errorMessage = str;
        }
        catch (IdIsNotUniqueException e){
            String str = "CSV contains not unique id";
            resultData.errorMessage = str;
        }
        catch (InvalidPathException e){
            String str = "CSV input file path is not correct\n" + e.getMessage();
            resultData.errorMessage = str;
        }
        catch (IllegalArgumentException e){
            String str = "No such enum difficulty value\n" + e.getMessage();
            resultData.errorMessage = str;
        }
        catch (FileSystemNotFoundException e){
            String str = "CSV file not found exception\n" + e.getMessage();
            resultData.errorMessage = str;
        }
        catch (SecurityException e){
            String str = "CSV access denied.File security exception";
            resultData.errorMessage = str;
        }
        catch (IOException e) {
            String str = "CSV some IO exception\n" + e.getMessage();
            resultData.errorMessage = str;
        }
        return resultData;
    }
    public ResultData saveToCSV(){
        ResultData resultData = new ResultData();
        try{
            CSVHandler.writeCollectionToCSV(filePath, (LabCollection) this);
            resultData.resultText = "Collection saved";
        }
        catch (IOException e){
            resultData.errorMessage = e.getMessage();
        }
        return resultData;
    }
    private void checkIdUnique(LinkedList<LabWork> list) throws IdIsNotUniqueException {
        boolean idIsUnique = true;
        for (int i = 0; i < list.size()-1; i++){
            if(!(idIsUnique)){
                break;
            }
            for (int j = i+1; j < list.size(); j++){
                if (list.get(i).getId().equals(list.get(j).getId())) {
                    idIsUnique = false;
                    break;
                }
            }
        }
        if (!idIsUnique) {
            throw new IdIsNotUniqueException();
        }
    }
    private void setIdPointerToMaxId(LinkedList<LabWork> list){
        int maxId = Integer.MIN_VALUE;
        for (LabWork lab : list){
            maxId = Math.max(maxId, lab.getId());
        }
        LabWork.collectionIDPointer = maxId + 1;
    }


}
