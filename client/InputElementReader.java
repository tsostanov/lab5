package client;
import exceptions.WrongInputException;
import labCollection.LabWork;
import static client.InputHandler.readWord;

/**
 * InputElementReader forms a new LabWork using input values.
 */
public class InputElementReader {
    public static LabWork readElementFromInput() {
        LabWork labWork = new LabWork();
        readName(labWork);
        readCoordinatesX(labWork);
        readCoordinatesY(labWork);
        readMinimalPoint(labWork);
        readTunedInWork(labWork);
        readDifficulty(labWork);
        readPersonName(labWork);
        readPersonHeight(labWork);
        readPersonEyeColor(labWork);
        readPersonHairColor(labWork);
        readPersonNationality(labWork);
        readPersonLocationX(labWork);
        readPersonLocationY(labWork);
        readPersonLocationName(labWork);
        return labWork;
    }
    private static void readName(LabWork labWork){
        try {
            labWork.setName(readWord("Type the name"));
        }catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readName(labWork);
        }
    }
    private static void readCoordinatesX(LabWork labWork){
        try{
            labWork.setCoordinatesX(readWord("Type the x coordinate"));
        }
        catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readCoordinatesX(labWork);
        }
        catch (NumberFormatException e){
            Message.Exceptions.mustBeType("long");
            readCoordinatesX(labWork);
        }
    }
    private static void readCoordinatesY(LabWork labWork){
        try{
            labWork.setCoordinatesY(readWord("Type the y coordinate"));
        }
        catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readCoordinatesY(labWork);
        }
        catch (NumberFormatException e){
            Message.Exceptions.mustBeType("long");
            readCoordinatesY(labWork);
        }
    }
    private static void readMinimalPoint(LabWork labWork){
        try{
            labWork.setMinimalPoint(readWord("Type the minimal point"));
        }
        catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readMinimalPoint(labWork);
        }
        catch (NumberFormatException e){
            Message.Exceptions.mustBeType("long");
            readMinimalPoint(labWork);
        }
    }

    private static void readTunedInWork(LabWork labWork){
        try{
            labWork.setTunedInWorks(readWord("Type amount of tuned in work assistants"));
        } catch (NumberFormatException e){
            Message.Exceptions.mustBeType("integer");
            readTunedInWork(labWork);
        }
    }
    private static void readDifficulty(LabWork labWork) {
        try {
            String str = readWord("Type the difficulty level.\n" +
                    "VERY_HARD, INSANE or TERRIBLE");
            labWork.setDifficulty(str);
        }catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readDifficulty(labWork);
        }
        catch (IllegalArgumentException e){
            Message.Exceptions.wrongEnumValue();
            readDifficulty(labWork);
        }
    }
    private static void readPersonName(LabWork labWork){
        try{
            labWork.setPersonName(readWord("Type Person's name"));
        }
        catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readPersonName(labWork);
        }
        catch (NumberFormatException e){
            Message.Exceptions.mustBeType("string");
            readPersonName(labWork);
        }
    }
    private static void readPersonHeight(LabWork labWork){
        try{
            labWork.setPersonHeight(readWord("Type Person's height"));
        } catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readPersonHeight(labWork);
        }
        catch (NumberFormatException e){
            Message.Exceptions.mustBeType("integer");
            readPersonHeight(labWork);
        }
    }
    private static void readPersonEyeColor(LabWork labWork) {
        try {
            String str = readWord("Type Person's eye color.\n" +
                    "RED, BLACK, YELLOW, BLUE, ORANGE or WITHE");
            labWork.setPersonEyeColor(str);
        } catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readPersonEyeColor(labWork);
        }catch (IllegalArgumentException e){
            Message.Exceptions.wrongEnumValue();
            readPersonEyeColor(labWork);
        }
    }
    private static void readPersonHairColor(LabWork labWork) {
        try {
            String str = readWord("Type Person's hair color.\n" +
                    "RED, BLACK, YELLOW, BLUE, ORANGE or WITHE");
            labWork.setPersonHairColor(str);
        } catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readPersonHairColor(labWork);
        }catch (IllegalArgumentException e){
            Message.Exceptions.wrongEnumValue();
            readPersonHairColor(labWork);
        }
    }

    private static void readPersonNationality(LabWork labWork){
        try {
            String str = readWord("Type Person's nationality.\n" + "RUSSIA, INDIA or NORTH_KOREA");
            labWork.setPersonNationality(str);
        } catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readPersonNationality(labWork);
        }catch (IllegalArgumentException e){
            Message.Exceptions.wrongEnumValue();
            readPersonNationality(labWork);
        }
    }
    private static void readPersonLocationX(LabWork labWork){
        try{
            labWork.setPersonLocationX(readWord("Type x Person's location coordinate"));
        }
        catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readPersonLocationX(labWork);
        }
        catch (NumberFormatException e){
            Message.Exceptions.mustBeType("integer");
            readPersonLocationX(labWork);
        }
    }
    private static void readPersonLocationY(LabWork labWork){
        try{
            labWork.setPersonLocationY(readWord("Type y Person's location coordinate"));
        }
        catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readPersonLocationY(labWork);
        }
        catch (NumberFormatException e){
            Message.Exceptions.mustBeType("float");
            readPersonLocationY(labWork);
        }
    }
    private static void readPersonLocationName(LabWork labWork){
        try{
            labWork.setPersonLocationName(readWord("Type name of Person's location"));
        }
        catch (WrongInputException e){
            Message.Exceptions.wrongInput(e);
            readPersonLocationName(labWork);
        }
        catch (NumberFormatException e){
            Message.Exceptions.mustBeType("string");
            readPersonLocationName(labWork);
        }
    }
}
