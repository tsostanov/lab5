package commands;

import client.ResultData;
import labCollection.LabCollection;
import labCollection.LabWork;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortCommand implements Command{
    private LinkedList<LabWork> labsList = new LinkedList<>();
    public ResultData sortId(){
        labsList = LabCollection.getLabList();
        ResultData resultData = new ResultData();
        Collections.sort(labsList, new Comparator<LabWork>() {
            @Override
            public int compare(LabWork o1, LabWork o2){
                return o1.getId() -o2.getId();
            }
        });
        resultData.resultText = "Elements in normal order";
        return resultData;
    }
    @Override
    public ResultData execute(CommandData commandData) {
        return sortId();
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
        return "sort";
    }

    @Override
    public String getDescription() {
        return "reorder elements in collection by their id";
    }
}