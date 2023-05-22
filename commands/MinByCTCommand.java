package commands;

import client.ResultData;
import labCollection.LabCollection;
import labCollection.LabWork;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MinByCTCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData min_by_ct(){
        labsList = LabCollection.getLabList();
        ResultData resultData = new ResultData();
        if(labsList.isEmpty()){
            resultData.resultText = "Collection is empty";
            return resultData;
        }
        resultData.labsList.add(Collections.min(labsList, new Comparator<LabWork>() {
            @Override
            public int compare(LabWork o1, LabWork o2) {
                return o1.compareTo(o2);
            }
        }));
        return resultData;
    }

    @Override
    public ResultData execute(CommandData commandData) {
        return min_by_ct();
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
        return "min_by_creation_time";
    }

    @Override
    public String getDescription() {
        return "show any element with minimal creation rime number";
    }
}