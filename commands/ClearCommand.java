package commands;

import client.ResultData;
import labCollection.*;
import labCollection.LabWork;

import java.util.LinkedList;

public class ClearCommand implements Command {
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData clear(){
        ResultData resultData = new ResultData();
        labsList = new LinkedList<>();
        LabCollection.updateLab(labsList);
        resultData.resultText = "Collection is cleared";
        return resultData;
    }

    @Override
    public ResultData execute(CommandData commandData) {
        return clear();
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
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clear the collection";
    }


}