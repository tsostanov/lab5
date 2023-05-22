package commands;

import client.ResultData;
import labCollection.LabCollection;
import labCollection.LabWork;

import java.util.LinkedList;



public class RemoveFirstCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData removeFirst(){
        labsList = LabCollection.getLabList();
        ResultData resultData = new ResultData();
        if (labsList.isEmpty()){
            resultData.resultText = "Collection is empty";
        }
        else {labsList.remove(0);
            resultData.resultText = "Element was deleted";
        }
        return resultData;
    }
    @Override
    public ResultData execute(CommandData commandData) {
        return removeFirst();
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
    public String getName() {
        return "remove_first";
    }

    @Override
    public String getDescription() {
        return "remove first element from collection";
    }
}
