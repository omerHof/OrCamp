package extractToWord;

import ViewModel.MyViewModel;
import org.apache.poi.hwpf.converter.AbstractWordUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class wordDuc {

    MyViewModel viewModel;

    public enum TextOrientation {
        LTR,
        RTL
    }

    public wordDuc(MyViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void createWordDuc(){
        try{
            XWPFDocument duc = new XWPFDocument(OPCPackage.open("C:/outputs/"+viewModel.getKidHebrow()+".docx"));
            //XWPFDocument duc = new XWPFDocument();
            //XWPFDocument duc = new XWPFDocument(AbstractWordUtils.class.getClassLoader().getResourceAsStream("C:/outputs/"+viewModel.getKidHebrow()+".docx"));

            FileOutputStream out = new FileOutputStream(new File("C:/outputs/"+viewModel.getKidHebrow()+"1.docx"));
            XWPFParagraph title = duc.createParagraph();
            title.setAlignment(ParagraphAlignment.CENTER);

            XWPFRun titleRun = title.createRun();
            titleRun.setText("דוח סיכום קייטנה");
            titleRun.setBold(true);
            titleRun.setFontSize(20);
            titleRun.setUnderline(UnderlinePatterns.SINGLE);

            XWPFParagraph paragraph = duc.createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.RIGHT);
            run.addBreak();
            run.setText("שם הילד:"+ viewModel.getKidHebrow()+System.lineSeparator());
            run.addBreak();
            run.setText("מדריכים: מיכל ועומר"+System.lineSeparator()+System.lineSeparator() );
            run.addBreak();
            run.addBreak();
            run.setText("איך הייתה הקייטנה עבורו באופן כללי? (איך הילד הגיע? תחושה כללית שלי לגביו? איך הוא ביחס לקייטנה קודמת)"+System.lineSeparator() );
            run.addBreak();
            if(viewModel.getGeneral()!=null){
                run.setText(viewModel.getGeneral()+System.lineSeparator()+System.lineSeparator());
            }
            run.addBreak();
            run.addBreak();
            run.setText("אירועים חיוביים משמעותיים שקרו:"+System.lineSeparator() );
            run.addBreak();
            if(viewModel.getPositive()!=null){
                run.setText(viewModel.getPositive()+System.lineSeparator()+System.lineSeparator());
            }
            run.addBreak();
            run.addBreak();
            run.setText("אירועים שליליים/קשים משמעותיים שקרו:"+System.lineSeparator());
            run.addBreak();
            if (viewModel.getNegative()!=null){
                run.setText(viewModel.getNegative()+System.lineSeparator()+System.lineSeparator());
            }
            run.addBreak();
            run.addBreak();
            run.setText("ממה הילד נהנה במהלך הקייטנה? אילו כוחות זיהיתי בו?"+System.lineSeparator() );
            run.addBreak();
            if(viewModel.getEnjoy()!=null){
                run.setText(viewModel.getEnjoy()+System.lineSeparator()+System.lineSeparator());
            }
            run.addBreak();
            run.addBreak();
            run.setText("איך הילד נענה למשמעת שלי כמדריך, התנהגות ומשמעת? כיצד התמודדתי עם זה?"+System.lineSeparator() );
            run.addBreak();
            if(viewModel.getDiscipline()!=null){
                run.setText(viewModel.getDiscipline());
            }
            run.addBreak();
            run.addBreak();
            run.setText("איך הילד השתלב מבחינה חברתית?"+System.lineSeparator());
            run.addBreak();
            if(viewModel.getSocial()!=null){
                run.setText(viewModel.getSocial()+System.lineSeparator()+System.lineSeparator());
            }
            run.addBreak();
            run.addBreak();
            run.setText("התייחסות לתחומים הבאים בקצרה:"+System.lineSeparator());
            run.setText("התמודדות בלילה (שינה, הרטבות וכו'):  ");
            if(viewModel.getNight()!=null){
                run.setText(viewModel.getNight()+System.lineSeparator());
            }
            run.addBreak();
            run.setText("ציוד אישי (ביגוד, ציוד אישי): ");
            if(viewModel.getEquipment()!=null){
                run.setText(viewModel.getEquipment()+System.lineSeparator() );
            }
            run.addBreak();
            run.setText("נטילת התרופות: ");
            if(viewModel.getDrugs()!=null){
                run.setText(viewModel.getDrugs()+System.lineSeparator());
            }
            run.addBreak();
            run.setText("בריאות: ");
            if(viewModel.getHealth()!=null){
                run.setText(viewModel.getHealth()+System.lineSeparator());
            }
            run.addBreak();
            run.setText("היגיינה: ");
            if(viewModel.getHygine()!=null){
                run.setText(viewModel.getHygine()+System.lineSeparator());
            }
            run.addBreak();
            run.setText("אוכל: ");
            if(viewModel.getFood()!=null){
                run.setText(viewModel.getFood()+System.lineSeparator()+System.lineSeparator());
            }
            run.addBreak();
            run.addBreak();
            run.setText("סיכום ודברים נוספים: "+System.lineSeparator());
            run.addBreak();
            if(viewModel.getSummary()!=null){
                run.setText(viewModel.getSummary()+System.lineSeparator());
            }
            run.addBreak();
            duc.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
