package commands;

import client.ResultData;
import labCollection.LabWork;

import java.util.LinkedList;

public class UpdateByIdCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData updateById(CommandData commandData){
        labsList = commandData.labCollection.getCollection();
        ResultData resultData = new ResultData();
        Integer id = commandData.intDigit-Integer.MIN_VALUE;
        boolean noSuchElement = true;
        for (LabWork labWork : labsList){
            if (labWork.getId().equals(id)){
                labWork.updateInfoFromElement(commandData.element);
                noSuchElement = false;
                break;
            }
        }
        if (noSuchElement){
            resultData.resultText = "There is no element with such id";
        }
        else{
            resultData.resultText = "Element was updated";
        }
        return resultData;
    }
    @Override
    public ResultData execute(CommandData commandData) {
        return updateById(commandData);
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
        return "update_by_id";
    }

    @Override
    public String getDescription() {
        return "update the element by his id number";
    }
}
