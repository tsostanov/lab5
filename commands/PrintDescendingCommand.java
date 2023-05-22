package commands;

import client.ResultData;
import labCollection.LabCollection;
import labCollection.LabWork;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PrintDescendingCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData printDescending(){
        labsList = LabCollection.getLabList();
        ResultData resultData = new ResultData();
        if (labsList.isEmpty()){
            resultData.resultText = "Collection is empty";
            return resultData;
        }
        int maxId = Collections.max(labsList, new Comparator<LabWork>() {
            @Override
            public int compare(LabWork o1, LabWork o2) {
                return o1.getId() - o2.getId();
            }
        }).getId();
        while (maxId + Integer.MAX_VALUE >= 0) {
            for (LabWork labWork : labsList) {
                if (labWork.getId().equals(maxId)) {
                    resultData.labsList.add(labWork);
                    break;
                }
            }
            maxId--;
        }
        return resultData;
    }
    @Override
    public ResultData execute(CommandData commandData) {
        return printDescending();
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
        return "print_descending";
    }

    @Override
    public String getDescription() {
        return "sorts the elements in descending order and show them";
    }
}
