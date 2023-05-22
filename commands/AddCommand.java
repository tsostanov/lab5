package commands;

import client.ResultData;
import labCollection.LabWork;

import java.util.LinkedList;


public class AddCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();

    public ResultData add(CommandData commandData){
        labsList = commandData.labCollection.getCollection();
        LabWork labWork = commandData.element;
        labWork.setId(LabWork.collectionIDPointer);
        labsList.add(commandData.element);
        ResultData resultData = new ResultData();
        resultData.labsList.add(commandData.element);
        resultData.resultText = "Element was successfully added";
        return resultData;
    }
    public ResultData execute(CommandData commandData) {
        return add(commandData);
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
        return false;
    }

    @Override
    public boolean hasString() {
        return false;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "add a new element";
    }
}
