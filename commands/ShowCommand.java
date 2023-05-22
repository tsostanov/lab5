package commands;

import client.ResultData;
import labCollection.LabCollection;
import labCollection.LabWork;

import java.util.LinkedList;

public class ShowCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData show(){
        labsList = LabCollection.getLabList();
        ResultData resultData = new ResultData();
        if (labsList.isEmpty()){
            resultData.resultText = "Collection is empty";
            return resultData;
        }
        resultData.labsList = labsList;
        return resultData;
    }
    public ResultData execute(CommandData commandData){
        return show();
    }

    @Override
    public boolean isClientCommand() {
        return false;
    }

    @Override
    public boolean hasElement() {
        return false;
    }
    @Override
    public boolean hasIntDigit() {
        return false;
    }
    @Override
    public boolean hasString() {
        return false;
    }
    @Override
    public String getName(){
        return "show";
    }
    @Override
    public String getDescription(){
        return "show all elements in the collection";
    }
}
