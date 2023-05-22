package commands;

import client.ResultData;
import labCollection.LabWork;

import java.util.LinkedList;

public class InsertAtIdCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData insertAtId(CommandData commandData){
        labsList = commandData.labCollection.getCollection();
        ResultData resultData = new ResultData();
        Integer id = commandData.intDigit-Integer.MIN_VALUE;
        for (LabWork labWork : labsList){
            if (labWork.getId().equals(id)){
                labsList.remove(labWork);
                break;
            }
        }
        LabWork labWork = commandData.element;
        labWork.placeId(id);
        labsList.add(commandData.element);
        resultData.labsList.add(commandData.element);
        resultData.resultText = "Element was updated";
        return resultData;
    }
    @Override
    public ResultData execute(CommandData commandData) {
        return insertAtId(commandData);
    }

    @Override
    public boolean isClientCommand() {
        return false;
    }

    @Override
    public boolean hasElement() {
        return true;
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
        return "insert_at_id";
    }

    @Override
    public String getDescription() {
        return "insert the element at id number";
    }
}
