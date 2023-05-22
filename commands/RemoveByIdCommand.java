package commands;

import client.ResultData;
import labCollection.LabWork;

import java.util.LinkedList;

public class RemoveByIdCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData removeById(CommandData commandData){
        labsList = commandData.labCollection.getCollection();
        ResultData resultData = new ResultData();
        Integer id = commandData.intDigit-Integer.MIN_VALUE;
        boolean noSuchElement = true;
        for (LabWork labWork : labsList){
            if (labWork.getId().equals(id)){
                labsList.remove(labWork);
                noSuchElement = false;
                break;
            }
        }
        if (noSuchElement){
            resultData.resultText = "There is no element with such id";
        }
        else{
            resultData.resultText = "Element was deleted";
        }
        return resultData;
    }
    @Override
    public ResultData execute(CommandData commandData) {
        return removeById(commandData);
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
        return true;
    }

    @Override
    public boolean hasString() {
        return false;
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "remove the element by his id number";
    }
}
