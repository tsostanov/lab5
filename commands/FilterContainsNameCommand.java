package commands;

import client.ResultData;
import labCollection.LabCollection;
import labCollection.LabWork;

import java.util.LinkedList;

public class FilterContainsNameCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData nameContains(CommandData commandData){
        labsList = LabCollection.getLabList();
        ResultData resultData = new ResultData();
        for (LabWork labWork : labsList){
            if (labWork.getName().contains(commandData.string)){
                resultData.labsList.add(labWork);
            }
        }
        if (resultData.labsList.isEmpty()){
            resultData.resultText = "There are no elements with such substring in the name";
        }
        return resultData;
    }
    @Override
    public ResultData execute(CommandData commandData) {
        return nameContains(commandData);
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
        return true;
    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }

    @Override
    public String getDescription() {
        return "show elements which names contains the string";
    }
}
