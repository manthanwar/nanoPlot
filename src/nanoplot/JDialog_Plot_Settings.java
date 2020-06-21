/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialog_Plot_Settings.java
 *
 * Created on 4 Apr, 2009, 4:41:37 PM
 */
package nanoplot;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Amit
 */
public class JDialog_Plot_Settings extends javax.swing.JDialog {

    private String formatString = "%.2f";

    //Plot Title
    private String plot_Title_Text;
    private Color plot_Title_Color;
    private String plot_Title_Font;
    private int plot_Title_FontSize;
    private float plot_Title_xAlign;
    private float plot_Title_yAlign;

    //Plot Line
    private float plot_Line_Size;
    private String plot_Line_Type;
    private Color plot_Line_Color;
    private Color plot_Background_Color;
    private float plot_Line_Style1;
    private float plot_Line_Style2;
    private float plot_Line_Style3;
    private float plot_Line_Style4;

    //Plot Maker
    private boolean plot_Marker_On;
    private float plot_Marker_Size;
    private String plot_Marker_Type;
    private Color plot_Marker_Color;
    private Color plot_Marker_FillColor;
    private float plot_Marker_Style1;
    private float plot_Marker_Style2;
    private float plot_Marker_Thickness;
//    private float plot_Marker_Style3;
//    private float plot_Marker_Style4;
    //Plot Box
    private boolean plot_Box_On;
    private int plot_Box_Padding1;
    private int plot_Box_Padding2;
    private int plot_Box_Padding3;
    private int plot_Box_Padding4;
    private float plot_Box_Size;
    private Color plot_Box_Color;
    private Color plot_Box_FillColor;
    private float plot_Box_Style1;
    private float plot_Box_Style2;
    private float plot_Box_Style3;
    private float plot_Box_Style4;
    //xLabel
    private String xAxis_Label_Text;
    private Color xAxis_Label_Color;
    private String xAxis_Label_Font;
    private int xAxis_Label_FontSize;
    private float xAxis_Label_xAlign;
    private float xAxis_Label_yAlign;

    //xAxis Limit
    private boolean xAxis_Auto;
    private float xAxis_Min;
    private float xAxis_Max;

    //xAxis Line
    private float xAxis_Line_Size;
    private Color xAxis_Line_Color;
    private float xAxis_Line_Style1;
    private float xAxis_Line_Style2;
    private float xAxis_Line_Style3;
    private float xAxis_Line_Style4;

    //xAxis Grid
    private boolean xAxis_Grid_On;
    private Color xAxis_Grid_Color;
    private float xAxis_Grid_Size;
    private float xAxis_Grid_Spacing;
    private float xAxis_Grid_Style1;
    private float xAxis_Grid_Style2;
    private float xAxis_Grid_Style3;
    private float xAxis_Grid_Style4;
    //xAxis TickMarks
    private boolean xAxis_TickMarks_On;
    private int xAxis_TickMarks_Size;
    private float xAxis_TickMarks_Spacing;
    private float xAxis_TickMarks_Length;
    private Color xAxis_TickMarks_Color;

    //xAxis TickLabel
    private boolean xAxis_TickLabel_On;
    private String xAxis_TickLabel_Font;
    private int xAxis_TickLabel_FontSize;
    private Color xAxis_TickLabel_Color;
    private float xAxis_TickLabel_xAlign;
    private float xAxis_TickLabel_yAlign;
    private float xAxis_TickLabel_Spacing;

    //yAxis Label
    private String yAxis_Label_Text;
    private Color yAxis_Label_Color;
    private String yAxis_Label_Font;
    private int yAxis_Label_FontSize;
    private float yAxis_Label_xAlign;
    private float yAxis_Label_yAlign;

    //yAxis Limit
    private boolean yAxis_Auto;
    private float yAxis_Min;
    private float yAxis_Max;

    //yAxis Line
    private float yAxis_Line_Size;
    private Color yAxis_Line_Color;
    private float yAxis_Line_Style1;
    private float yAxis_Line_Style2;
    private float yAxis_Line_Style3;
    private float yAxis_Line_Style4;

    //yAxis Grid
    private boolean yAxis_Grid_On;
    private Color yAxis_Grid_Color;
    private float yAxis_Grid_Size;
    private float yAxis_Grid_Spacing;
    private float yAxis_Grid_Style1;
    private float yAxis_Grid_Style2;
    private float yAxis_Grid_Style3;
    private float yAxis_Grid_Style4;
    //yAxis TickMarks
    private boolean yAxis_TickMarks_On;
    private int yAxis_TickMarks_Size;
    private float yAxis_TickMarks_Spacing;
    private float yAxis_TickMarks_Length;
    private Color yAxis_TickMarks_Color;

    //yAxis TickLabel
    private boolean yAxis_TickLabel_On;
    private String yAxis_TickLabel_Font;
    private int yAxis_TickLabel_FontSize;
    private Color yAxis_TickLabel_Color;
    private float yAxis_TickLabel_xAlign;
    private float yAxis_TickLabel_yAlign;
    private float yAxis_TickLabel_Spacing;
    private boolean dialogOkSuccess;
    private JPanel_Plot parentPlot;
    InputVerifier verifyInt = new InputVerifier() {

        public boolean verify(JComponent comp) {
            boolean returnValue = true;
            JTextField textField = (JTextField) comp;
            textField.setForeground(Color.BLUE);
            textField.setBackground(Color.WHITE);
            String content = textField.getText();
            if (content.length() != 0) {
                try {
                    Integer.parseInt(textField.getText());
                }
                catch (NumberFormatException e) {
                    getToolkit().beep();
                    returnValue = false;
                    textField.setForeground(Color.RED);
                    textField.setBackground(Color.YELLOW);
                    JOptionPane.showMessageDialog(null, "Accepts only Integer Number.", "Plot Settings", JOptionPane.OK_OPTION);
                }
            }
            return returnValue;
        }
    };
    InputVerifier verifyFloat = new InputVerifier() {

        public boolean verify(JComponent comp) {
            boolean returnValue = true;
            JTextField textField = (JTextField) comp;
            textField.setForeground(Color.BLUE);
            textField.setBackground(Color.WHITE);
            String content = textField.getText();
            if (content.length() != 0) {
                try {
                    Float.parseFloat(textField.getText());
                }
                catch (NumberFormatException e) {
                    getToolkit().beep();
                    returnValue = false;
                    textField.setForeground(Color.RED);
                    textField.setBackground(Color.YELLOW);
                    JOptionPane.showMessageDialog(null, "Accepts only Real Number.", "Plot Settings", JOptionPane.OK_OPTION);
                }
            }
            return returnValue;
        }
    };

    //Default Settings
    public void setDefaultValues() {

        formatString = "%.2f";
        dialogOkSuccess = false;
        //Plot
        plot_Title_Text = "";
        plot_Title_Color = Color.BLACK;
        plot_Title_Font = "Tahoma Bold";
        plot_Title_FontSize = 14;
        plot_Title_xAlign = 10;
        plot_Title_yAlign = 10;

        //Plot Line
        plot_Line_Size = 1.5f;
        plot_Line_Type = "Line";
        plot_Line_Color = Color.BLUE;
        plot_Background_Color = new Color(240, 240, 240);//default system gray
        plot_Line_Style1 = 2.0f;
        plot_Line_Style2 = 0;
        plot_Line_Style3 = 0;
        plot_Line_Style4 = 0;

        //Plot Maker
        plot_Marker_On = false;
        plot_Marker_Size = 10;
        plot_Marker_Type = "Circle";
        plot_Marker_Color = Color.WHITE;
        plot_Marker_FillColor = Color.WHITE;
        plot_Marker_Style1 = 2.0f;
        plot_Marker_Style2 = 0;
        plot_Marker_Thickness = 2.0f;
//        plot_Marker_Style3 = 0;
//        plot_Marker_Style4 = 0;

        //Plot Box
        plot_Box_Padding1 = 20;
        plot_Box_Padding2 = 20;
        plot_Box_Padding3 = 20;
        plot_Box_Padding4 = 20;
        plot_Box_On = true;
        plot_Box_Size = 1.0f;
        plot_Box_Color = Color.BLACK;
        plot_Box_FillColor = Color.WHITE;
        plot_Box_Style1 = 2.0f;
        plot_Box_Style2 = 0;
        plot_Box_Style3 = 0;
        plot_Box_Style4 = 0;


        //xLabel
        xAxis_Label_Text = "";
        xAxis_Label_Color = Color.BLACK;
        xAxis_Label_Font = "Tahoma";
        xAxis_Label_FontSize = 11;
        xAxis_Label_xAlign = 10;
        xAxis_Label_yAlign = 10;

        //xAxis Limit
        xAxis_Auto = true;
        xAxis_Min = 0;
        xAxis_Max = 1;

        //xAxis Line
        xAxis_Line_Size = 1.0f;
        xAxis_Line_Color = Color.BLACK;
        xAxis_Line_Style1 = 2.0f;
        xAxis_Line_Style2 = 0;
        xAxis_Line_Style3 = 0;
        xAxis_Line_Style4 = 0;

        //xAxis Grid
        xAxis_Grid_On = true;
        xAxis_Grid_Color = Color.GRAY;
        xAxis_Grid_Size = 0.4f;
        xAxis_Grid_Spacing = 10;
        xAxis_Grid_Style1 = 2.0f;
        xAxis_Grid_Style2 = 4.0f;
        xAxis_Grid_Style3 = 2.0f;
        xAxis_Grid_Style4 = 4.0f;

        //xAxis TickMarks
        xAxis_TickMarks_On = false;
        xAxis_TickMarks_Size = 1;
        xAxis_TickMarks_Spacing = 10.0f;
        xAxis_TickMarks_Length = 5.0f;
        xAxis_TickMarks_Color = Color.BLACK;

        //xAxis TickLabel
        xAxis_TickLabel_On = true;
        xAxis_TickLabel_Font = "Tahoma";
        xAxis_TickLabel_FontSize = 10;
        xAxis_TickLabel_Color = Color.BLACK;
        xAxis_TickLabel_xAlign = 10;
        xAxis_TickLabel_yAlign = 10;
        xAxis_TickLabel_Spacing = 1.0f;

        //yAxis Label
        yAxis_Label_Text = "";
        yAxis_Label_Color = Color.BLACK;
        yAxis_Label_Font = "Tahoma";
        yAxis_Label_FontSize = 11;
        yAxis_Label_xAlign = 10;
        yAxis_Label_yAlign = 10;

        //yAxis Limit
        yAxis_Auto = true;
        yAxis_Min = 0;
        yAxis_Max = 1;

        //yAxis Line
        yAxis_Line_Size = 1.0f;
        yAxis_Line_Color = Color.BLACK;
        yAxis_Line_Style1 = 2.0f;
        yAxis_Line_Style2 = 0;
        yAxis_Line_Style3 = 0;
        yAxis_Line_Style4 = 0;

        //yAxis Grid
        yAxis_Grid_On = true;
        yAxis_Grid_Color = Color.GRAY;
        yAxis_Grid_Size = 0.4f;
        yAxis_Grid_Spacing = 10;
        yAxis_Grid_Style1 = 2.0f;
        yAxis_Grid_Style2 = 4.0f;
        yAxis_Grid_Style3 = 2.0f;
        yAxis_Grid_Style4 = 4.0f;

        //yAxis TickMarks
        yAxis_TickMarks_On = false;
        yAxis_TickMarks_Size = 1;
        yAxis_TickMarks_Spacing = 10.0f;
        yAxis_TickMarks_Length = 1.0f;
        yAxis_TickMarks_Color = Color.BLACK;

        //yAxis TickLabel
        yAxis_TickLabel_On = true;
        yAxis_TickLabel_Font = "Tahoma";
        yAxis_TickLabel_FontSize = 10;
        yAxis_TickLabel_Color = Color.BLACK;
        yAxis_TickLabel_xAlign = 10;
        yAxis_TickLabel_yAlign = 10;
        yAxis_TickLabel_Spacing = 1.0f;
    }

    //Default Settings
    public void getParentValues(JPanel_Plot aThis) {

        //Plot
        plot_Title_Text = aThis.getPlot_Title_Text();
        plot_Title_Color = aThis.getPlot_Title_Color();
        plot_Title_Font = aThis.getPlot_Title_Font();
        plot_Title_FontSize = aThis.getPlot_Title_FontSize();
        plot_Title_xAlign = aThis.getPlot_Title_xAlign();
        plot_Title_yAlign = aThis.getPlot_Title_yAlign();

        //Plot Line
        plot_Line_Size = aThis.getPlot_Line_Size();
        plot_Line_Type = aThis.getPlot_Line_Type();
        plot_Line_Color = aThis.getPlot_Line_Color();
        plot_Background_Color = aThis.getPlot_Background_Color();
        plot_Line_Style1 = aThis.getPlot_Line_Style1();
        plot_Line_Style2 = aThis.getPlot_Line_Style2();
        plot_Line_Style3 = aThis.getPlot_Line_Style3();
        plot_Line_Style4 = aThis.getPlot_Line_Style4();

        //Plot Maker
        plot_Marker_On = aThis.getPlot_Marker_On();
        plot_Marker_Size = aThis.getPlot_Marker_Size();
        plot_Marker_Type = aThis.getPlot_Marker_Type();
        plot_Marker_Color = aThis.getPlot_Marker_Color();
        plot_Marker_FillColor = aThis.getPlot_Marker_FillColor();
        plot_Marker_Style1 = aThis.getPlot_Marker_Style1();
        plot_Marker_Style2 = aThis.getPlot_Marker_Style2();
        plot_Marker_Thickness = aThis.getPlot_Marker_Thickness();
//        plot_Marker_Style3 = aThis.getPlot_Marker_Style3();
//        plot_Marker_Style4 = aThis.getPlot_Marker_Style4();

        //Plot Box
        plot_Box_Padding1 = aThis.getPlot_Box_Padding1();
        plot_Box_Padding2 = aThis.getPlot_Box_Padding2();
        plot_Box_Padding3 = aThis.getPlot_Box_Padding3();
        plot_Box_Padding4 = aThis.getPlot_Box_Padding4();

        plot_Box_On = aThis.getPlot_Box_On();
        plot_Box_Size = aThis.getPlot_Box_Size();
        plot_Box_Color = aThis.getPlot_Box_Color();
        plot_Box_FillColor = aThis.getPlot_Box_FillColor();
        plot_Box_Style1 = aThis.getPlot_Box_Style1();
        plot_Box_Style2 = aThis.getPlot_Box_Style2();
        plot_Box_Style3 = aThis.getPlot_Box_Style3();
        plot_Box_Style4 = aThis.getPlot_Box_Style4();


        //xLabel
        xAxis_Label_Text = aThis.getXAxis_Label_Text();
        xAxis_Label_Color = aThis.getXAxis_Label_Color();
        xAxis_Label_Font = aThis.getXAxis_Label_Font();
        xAxis_Label_FontSize = aThis.getXAxis_Label_FontSize();
        xAxis_Label_xAlign = aThis.getXAxis_Label_xAlign();
        xAxis_Label_yAlign = aThis.getXAxis_Label_yAlign();

        //xAxis Limit
        xAxis_Auto = aThis.getXAxis_Auto();

        //xAxis Line
        xAxis_Line_Size = aThis.getXAxis_Line_Size();
        xAxis_Line_Color = aThis.getXAxis_Line_Color();
        xAxis_Line_Style1 = aThis.getXAxis_Line_Style1();
        xAxis_Line_Style2 = aThis.getXAxis_Line_Style2();
        xAxis_Line_Style3 = aThis.getXAxis_Line_Style3();
        xAxis_Line_Style4 = aThis.getXAxis_Line_Style4();

        //xAxis Grid
        xAxis_Grid_On = aThis.getXAxis_Grid_On();
        xAxis_Grid_Color = aThis.getXAxis_Grid_Color();
        xAxis_Grid_Size = aThis.getXAxis_Grid_Size();
        xAxis_Grid_Spacing = aThis.getXAxis_Grid_Spacing();
        xAxis_Grid_Style1 = aThis.getXAxis_Grid_Style1();
        xAxis_Grid_Style2 = aThis.getXAxis_Grid_Style2();
        xAxis_Grid_Style3 = aThis.getXAxis_Grid_Style3();
        xAxis_Grid_Style4 = aThis.getXAxis_Grid_Style4();

        //xAxis TickMarks
        xAxis_TickMarks_On = aThis.getXAxis_TickMarks_On();
        xAxis_TickMarks_Size = aThis.getXAxis_TickMarks_Size();
        xAxis_TickMarks_Spacing = aThis.getXAxis_TickMarks_Spacing();
        xAxis_TickMarks_Length = aThis.getXAxis_TickMarks_Length();
        xAxis_TickMarks_Color = aThis.getXAxis_TickMarks_Color();

        //xAxis TickLabel
        xAxis_TickLabel_On = aThis.getXAxis_TickLabel_On();
        xAxis_TickLabel_Font = aThis.getXAxis_TickLabel_Font();
        xAxis_TickLabel_FontSize = aThis.getXAxis_TickLabel_FontSize();
        xAxis_TickLabel_Color = aThis.getXAxis_TickLabel_Color();
        xAxis_TickLabel_xAlign = aThis.getXAxis_TickLabel_xAlign();
        xAxis_TickLabel_yAlign = aThis.getXAxis_TickLabel_yAlign();
        xAxis_TickLabel_Spacing = aThis.getXAxis_TickLabel_Spacing();


        //xLabel
        yAxis_Label_Text = aThis.getYAxis_Label_Text();
        yAxis_Label_Color = aThis.getYAxis_Label_Color();
        yAxis_Label_Font = aThis.getYAxis_Label_Font();
        yAxis_Label_FontSize = aThis.getYAxis_Label_FontSize();
        yAxis_Label_xAlign = aThis.getYAxis_Label_xAlign();
        yAxis_Label_yAlign = aThis.getYAxis_Label_yAlign();

        //yAxis Limit
        yAxis_Auto = aThis.getYAxis_Auto();

        //yAxis Line
        yAxis_Line_Size = aThis.getYAxis_Line_Size();
        yAxis_Line_Color = aThis.getYAxis_Line_Color();
        yAxis_Line_Style1 = aThis.getYAxis_Line_Style1();
        yAxis_Line_Style2 = aThis.getYAxis_Line_Style2();
        yAxis_Line_Style3 = aThis.getYAxis_Line_Style3();
        yAxis_Line_Style4 = aThis.getYAxis_Line_Style4();

        //yAxis Grid
        yAxis_Grid_On = aThis.getYAxis_Grid_On();
        yAxis_Grid_Color = aThis.getYAxis_Grid_Color();
        yAxis_Grid_Size = aThis.getYAxis_Grid_Size();
        yAxis_Grid_Spacing = aThis.getYAxis_Grid_Spacing();
        yAxis_Grid_Style1 = aThis.getYAxis_Grid_Style1();
        yAxis_Grid_Style2 = aThis.getYAxis_Grid_Style2();
        yAxis_Grid_Style3 = aThis.getYAxis_Grid_Style3();
        yAxis_Grid_Style4 = aThis.getYAxis_Grid_Style4();

        //yAxis TickMarks
        yAxis_TickMarks_On = aThis.getYAxis_TickMarks_On();
        yAxis_TickMarks_Size = aThis.getYAxis_TickMarks_Size();
        yAxis_TickMarks_Spacing = aThis.getYAxis_TickMarks_Spacing();
        yAxis_TickMarks_Length = aThis.getYAxis_TickMarks_Length();
        yAxis_TickMarks_Color = aThis.getYAxis_TickMarks_Color();

        //yAxis TickLabel
        yAxis_TickLabel_On = aThis.getYAxis_TickLabel_On();
        yAxis_TickLabel_Font = aThis.getYAxis_TickLabel_Font();
        yAxis_TickLabel_FontSize = aThis.getYAxis_TickLabel_FontSize();
        yAxis_TickLabel_Color = aThis.getYAxis_TickLabel_Color();
        yAxis_TickLabel_xAlign = aThis.getYAxis_TickLabel_xAlign();
        yAxis_TickLabel_yAlign = aThis.getYAxis_TickLabel_yAlign();
        yAxis_TickLabel_Spacing = aThis.getYAxis_TickLabel_Spacing();
    }

    //Validate the input TextFields
    private void setVerifiers() {
        //Plot Title
        jTextField_plot_Title_FontSize.setInputVerifier(verifyInt);
        jTextField_plot_Title_xAlign.setInputVerifier(verifyFloat);
        jTextField_plot_Title_yAlign.setInputVerifier(verifyFloat);

        //Plot Line
        jTextField_plot_Line_Size.setInputVerifier(verifyFloat);
        jTextField_plot_Line_Style1.setInputVerifier(verifyFloat);
        jTextField_plot_Line_Style2.setInputVerifier(verifyFloat);
        jTextField_plot_Line_Style3.setInputVerifier(verifyFloat);
        jTextField_plot_Line_Style4.setInputVerifier(verifyFloat);

        //Plot Maker
        jTextField_plot_Marker_Size.setInputVerifier(verifyFloat);
        jTextField_plot_Marker_Style1.setInputVerifier(verifyFloat);
        jTextField_plot_Marker_Style2.setInputVerifier(verifyFloat);
        jTextField_plot_Marker_Thickness.setInputVerifier(verifyFloat);

        //Plot Box
        jTextField_plot_Box_Padding1.setInputVerifier(verifyInt);
        jTextField_plot_Box_Padding2.setInputVerifier(verifyInt);
        jTextField_plot_Box_Padding3.setInputVerifier(verifyInt);
        jTextField_plot_Box_Padding4.setInputVerifier(verifyInt);
        jTextField_plot_Box_Size.setInputVerifier(verifyFloat);
        jTextField_plot_Box_Style1.setInputVerifier(verifyFloat);
        jTextField_plot_Box_Style2.setInputVerifier(verifyFloat);
        jTextField_plot_Box_Style3.setInputVerifier(verifyFloat);
        jTextField_plot_Box_Style4.setInputVerifier(verifyFloat);

        //xAxis Label
        jTextField_xAxis_Label_FontSize.setInputVerifier(verifyInt);
        jTextField_xAxis_Label_xAlign.setInputVerifier(verifyFloat);
        jTextField_xAxis_Label_yAlign.setInputVerifier(verifyFloat);

        //xAxis Limit
        jTextField_xAxis_Min.setInputVerifier(verifyFloat);
        jTextField_xAxis_Max.setInputVerifier(verifyFloat);

        //xAxis Line
        jTextField_xAxis_Line_Size.setInputVerifier(verifyFloat);
        jTextField_xAxis_Line_Style1.setInputVerifier(verifyFloat);
        jTextField_xAxis_Line_Style2.setInputVerifier(verifyFloat);
        jTextField_xAxis_Line_Style3.setInputVerifier(verifyFloat);
        jTextField_xAxis_Line_Style4.setInputVerifier(verifyFloat);

        //xAxis Grid
        jTextField_xAxis_Grid_Size.setInputVerifier(verifyFloat);
        jTextField_xAxis_Grid_Spacing.setInputVerifier(verifyFloat);
        jTextField_xAxis_Grid_Style1.setInputVerifier(verifyFloat);
        jTextField_xAxis_Grid_Style2.setInputVerifier(verifyFloat);
        jTextField_xAxis_Grid_Style3.setInputVerifier(verifyFloat);
        jTextField_xAxis_Grid_Style4.setInputVerifier(verifyFloat);

        //xAxis TickMarks
        jTextField_xAxis_TickMarks_Size.setInputVerifier(verifyInt);
        jTextField_xAxis_TickMarks_Spacing.setInputVerifier(verifyFloat);
        jTextField_xAxis_TickMarks_Length.setInputVerifier(verifyFloat);

        //xAxis TickLabel
        jTextField_xAxis_TickLabel_FontSize.setInputVerifier(verifyInt);
        jTextField_xAxis_TickLabel_xAlign.setInputVerifier(verifyFloat);
        jTextField_xAxis_TickLabel_yAlign.setInputVerifier(verifyFloat);
        jTextField_xAxis_TickLabel_Spacing.setInputVerifier(verifyFloat);


        //yAxis Label
        jTextField_yAxis_Label_FontSize.setInputVerifier(verifyInt);
        jTextField_yAxis_Label_xAlign.setInputVerifier(verifyFloat);
        jTextField_yAxis_Label_yAlign.setInputVerifier(verifyFloat);

        //yAxis Limit
        jTextField_yAxis_Min.setInputVerifier(verifyFloat);
        jTextField_yAxis_Max.setInputVerifier(verifyFloat);

        //yAxis Line
        jTextField_yAxis_Line_Size.setInputVerifier(verifyFloat);
        jTextField_yAxis_Line_Style1.setInputVerifier(verifyFloat);
        jTextField_yAxis_Line_Style2.setInputVerifier(verifyFloat);
        jTextField_yAxis_Line_Style3.setInputVerifier(verifyFloat);
        jTextField_yAxis_Line_Style4.setInputVerifier(verifyFloat);

        //yAxis Grid
        jTextField_yAxis_Grid_Size.setInputVerifier(verifyFloat);
        jTextField_yAxis_Grid_Spacing.setInputVerifier(verifyFloat);
        jTextField_yAxis_Grid_Style1.setInputVerifier(verifyFloat);
        jTextField_yAxis_Grid_Style2.setInputVerifier(verifyFloat);
        jTextField_yAxis_Grid_Style3.setInputVerifier(verifyFloat);
        jTextField_yAxis_Grid_Style4.setInputVerifier(verifyFloat);

        //yAxis TickMarks
        jTextField_yAxis_TickMarks_Size.setInputVerifier(verifyInt);
        jTextField_yAxis_TickMarks_Spacing.setInputVerifier(verifyFloat);
        jTextField_yAxis_TickMarks_Length.setInputVerifier(verifyFloat);

        //yAxis TickLabel
        jTextField_yAxis_TickLabel_FontSize.setInputVerifier(verifyInt);
        jTextField_yAxis_TickLabel_xAlign.setInputVerifier(verifyFloat);
        jTextField_yAxis_TickLabel_yAlign.setInputVerifier(verifyFloat);
        jTextField_yAxis_TickLabel_Spacing.setInputVerifier(verifyFloat);


    }

    private void setTextFieldsToolTipText() {

        //Plot Title
        jTextField_plot_Title_FontSize.setToolTipText("Set Integer");
        jTextField_plot_Title_xAlign.setToolTipText("Set Real Number");
        jTextField_plot_Title_yAlign.setToolTipText("Set Real Number");

        //Plot Line
        jTextField_plot_Line_Size.setToolTipText("Set Real Number");
        jTextField_plot_Line_Style1.setToolTipText("Set Real Number");
        jTextField_plot_Line_Style2.setToolTipText("Set Real Number");
        jTextField_plot_Line_Style3.setToolTipText("Set Real Number");
        jTextField_plot_Line_Style4.setToolTipText("Set Real Number");

        //Plot Maker
        jTextField_plot_Marker_Size.setToolTipText("Set Real Number");
        jTextField_plot_Marker_Style1.setToolTipText("Set Real Number");
        jTextField_plot_Marker_Style2.setToolTipText("Set Real Number");
        jTextField_plot_Marker_Thickness.setToolTipText("Set Real Number");

        //Plot Box
        jTextField_plot_Box_Padding1.setToolTipText("Set Integer");
        jTextField_plot_Box_Padding2.setToolTipText("Set Integer");
        jTextField_plot_Box_Padding3.setToolTipText("Set Integer");
        jTextField_plot_Box_Padding4.setToolTipText("Set Integer");
        jTextField_plot_Box_Size.setToolTipText("Set Real Number");
        jTextField_plot_Box_Style1.setToolTipText("Set Real Number");
        jTextField_plot_Box_Style2.setToolTipText("Set Real Number");
        jTextField_plot_Box_Style3.setToolTipText("Set Real Number");
        jTextField_plot_Box_Style4.setToolTipText("Set Real Number");


        //xAxis Label
        jTextField_xAxis_Label_FontSize.setToolTipText("Set Integer");
        jTextField_xAxis_Label_xAlign.setToolTipText("Set Real Number");
        jTextField_xAxis_Label_yAlign.setToolTipText("Set Real Number");

        //xAxis Limit
        jTextField_xAxis_Min.setToolTipText("Set Real Number");
        jTextField_xAxis_Max.setToolTipText("Set Real Number");

        //xAxis Line
        jTextField_xAxis_Line_Size.setToolTipText("Set Real Number");
        jTextField_xAxis_Line_Style1.setToolTipText("Set Real Number");
        jTextField_xAxis_Line_Style2.setToolTipText("Set Real Number");
        jTextField_xAxis_Line_Style3.setToolTipText("Set Real Number");
        jTextField_xAxis_Line_Style4.setToolTipText("Set Real Number");

        //xAxis Grid
        jTextField_xAxis_Grid_Size.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Spacing.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Style1.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Style2.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Style3.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Style4.setToolTipText("Set Real Number");

        //xAxis TickMarks
        jTextField_xAxis_TickMarks_Size.setToolTipText("Set Integer");
        jTextField_xAxis_TickMarks_Spacing.setToolTipText("Set Real Number");
        jTextField_xAxis_TickMarks_Length.setToolTipText("Set Real Number");

        //xAxis TickLabel
        jTextField_xAxis_TickLabel_FontSize.setToolTipText("Set Integer");
        jTextField_xAxis_TickLabel_xAlign.setToolTipText("Set Real Number");
        jTextField_xAxis_TickLabel_yAlign.setToolTipText("Set Real Number");
        jTextField_xAxis_TickLabel_Spacing.setToolTipText("Set Real Number");


        //yAxis Label
        jTextField_yAxis_Label_FontSize.setToolTipText("Set Integer");
        jTextField_yAxis_Label_xAlign.setToolTipText("Set Real Number");
        jTextField_yAxis_Label_yAlign.setToolTipText("Set Real Number");

        //yAxis Limit
        jTextField_yAxis_Min.setToolTipText("Set Real Number");
        jTextField_yAxis_Max.setToolTipText("Set Real Number");

        //yAxis Line
        jTextField_yAxis_Line_Size.setToolTipText("Set Real Number");
        jTextField_yAxis_Line_Style1.setToolTipText("Set Real Number");
        jTextField_yAxis_Line_Style2.setToolTipText("Set Real Number");
        jTextField_yAxis_Line_Style3.setToolTipText("Set Real Number");
        jTextField_yAxis_Line_Style4.setToolTipText("Set Real Number");

        //yAxis Grid
        jTextField_yAxis_Grid_Size.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Spacing.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Style1.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Style2.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Style3.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Style4.setToolTipText("Set Real Number");

        //yAxis TickMarks
        jTextField_yAxis_TickMarks_Size.setToolTipText("Set Integer");
        jTextField_yAxis_TickMarks_Spacing.setToolTipText("Set Real Number");
        jTextField_yAxis_TickMarks_Length.setToolTipText("Set Real Number");

        //yAxis TickLabel
        jTextField_yAxis_TickLabel_FontSize.setToolTipText("Set Integer");
        jTextField_yAxis_TickLabel_xAlign.setToolTipText("Set Real Number");
        jTextField_yAxis_TickLabel_yAlign.setToolTipText("Set Real Number");
        jTextField_yAxis_TickLabel_Spacing.setToolTipText("Set Real Number");

    }

    /** Creates new form JDialog_Plot_Settings */
    public JDialog_Plot_Settings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        renderComboBox();


        setDefaultValues();

        setSettings();

    }

    public JDialog_Plot_Settings(JPanel_Plot aThis) {

        parentPlot = aThis;
        setLAF();
        //setDefaultValues();
        //Set Verifiers
        //setTextFieldsToolTipText();
        //setVerifiers();

        // getParentValues(aThis);
        // setSettings();
        initComponents();
        renderComboBox();



    }

    protected void setAxisAuto() {
        if (xAxis_Auto) {
            jTextField_xAxis_Min.setEditable(false);
            jTextField_xAxis_Max.setEditable(false);
        }
        else {
            jTextField_xAxis_Min.setEditable(true);
            jTextField_xAxis_Max.setEditable(true);
        }
        if (yAxis_Auto) {
            jTextField_yAxis_Min.setEditable(false);
            jTextField_yAxis_Max.setEditable(false);
        }
        else {
            jTextField_yAxis_Min.setEditable(true);
            jTextField_yAxis_Max.setEditable(true);
        }
    }

    protected void setXYGridOn() {
        if (!xAxis_Grid_On) {
            jTextField_xAxis_Grid_Size.setEditable(false);
            jTextField_xAxis_Grid_Spacing.setEditable(false);
            jTextField_xAxis_Grid_Style1.setEditable(false);
            jTextField_xAxis_Grid_Style2.setEditable(false);
            jTextField_xAxis_Grid_Style3.setEditable(false);
            jTextField_xAxis_Grid_Style4.setEditable(false);
            jPanel_xAxis_Grid_Color.setVisible(false);

        }
        else {
            jTextField_xAxis_Grid_Size.setEditable(true);
            jTextField_xAxis_Grid_Spacing.setEditable(true);
            jTextField_xAxis_Grid_Style1.setEditable(true);
            jTextField_xAxis_Grid_Style2.setEditable(true);
            jTextField_xAxis_Grid_Style3.setEditable(true);
            jTextField_xAxis_Grid_Style4.setEditable(true);
            jPanel_xAxis_Grid_Color.setVisible(true);
        }
        if (!yAxis_Grid_On) {
            jTextField_yAxis_Grid_Size.setEditable(false);
            jTextField_yAxis_Grid_Spacing.setEditable(false);
            jTextField_yAxis_Grid_Style1.setEditable(false);
            jTextField_yAxis_Grid_Style2.setEditable(false);
            jTextField_yAxis_Grid_Style3.setEditable(false);
            jTextField_yAxis_Grid_Style4.setEditable(false);
            jPanel_yAxis_Grid_Color.setVisible(false);

        }
        else {
            jTextField_yAxis_Grid_Size.setEditable(true);
            jTextField_yAxis_Grid_Spacing.setEditable(true);
            jTextField_yAxis_Grid_Style1.setEditable(true);
            jTextField_yAxis_Grid_Style2.setEditable(true);
            jTextField_yAxis_Grid_Style3.setEditable(true);
            jTextField_yAxis_Grid_Style4.setEditable(true);
            jPanel_yAxis_Grid_Color.setVisible(true);
        }


        if (!xAxis_TickMarks_On) {
            jTextField_xAxis_TickMarks_Size.setEditable(false);
            jTextField_xAxis_TickMarks_Spacing.setEditable(false);
            jPanel_xAxis_TickMarks_Color.setVisible(false);
            jTextField_xAxis_TickMarks_Length.setEditable(false);
        }
        else {
            jTextField_xAxis_TickMarks_Size.setEditable(true);
            jTextField_xAxis_TickMarks_Spacing.setEditable(true);
            jPanel_xAxis_TickMarks_Color.setVisible(true);
            jTextField_xAxis_TickMarks_Length.setEditable(true);
        }


        if (!yAxis_TickMarks_On) {
            jTextField_yAxis_TickMarks_Size.setEditable(false);
            jTextField_yAxis_TickMarks_Spacing.setEditable(false);
            jPanel_yAxis_TickMarks_Color.setVisible(false);
            jTextField_yAxis_TickMarks_Length.setEditable(false);
        }
        else {
            jTextField_yAxis_TickMarks_Size.setEditable(true);
            jTextField_yAxis_TickMarks_Spacing.setEditable(true);
            jPanel_yAxis_TickMarks_Color.setVisible(true);
            jTextField_yAxis_TickMarks_Length.setEditable(true);
        }


        if (!xAxis_TickLabel_On) {
            jComboBox_xAxis_TickLabel_Font.setEditable(false);
            jTextField_xAxis_TickLabel_FontSize.setEditable(false);
            jPanel_xAxis_TickLabel_Color.setVisible(false);
            jTextField_xAxis_TickLabel_xAlign.setEditable(false);
            jTextField_xAxis_TickLabel_yAlign.setEditable(false);
            jTextField_xAxis_TickLabel_Spacing.setEditable(false);
        }
        else {
            jComboBox_xAxis_TickLabel_Font.setEditable(true);
            jTextField_xAxis_TickLabel_FontSize.setEditable(true);
            jPanel_xAxis_TickLabel_Color.setVisible(true);
            jTextField_xAxis_TickLabel_xAlign.setEditable(true);
            jTextField_xAxis_TickLabel_yAlign.setEditable(true);
            jTextField_xAxis_TickLabel_Spacing.setEditable(true);
        }

        if (!yAxis_TickLabel_On) {
            jComboBox_yAxis_TickLabel_Font.setEditable(false);
            jTextField_yAxis_TickLabel_FontSize.setEditable(false);
            jPanel_yAxis_TickLabel_Color.setVisible(false);
            jTextField_yAxis_TickLabel_xAlign.setEditable(false);
            jTextField_yAxis_TickLabel_yAlign.setEditable(false);
            jTextField_yAxis_TickLabel_Spacing.setEditable(false);
        }
        else {
            jComboBox_yAxis_TickLabel_Font.setEditable(true);
            jTextField_yAxis_TickLabel_FontSize.setEditable(true);
            jPanel_yAxis_TickLabel_Color.setVisible(true);
            jTextField_yAxis_TickLabel_xAlign.setEditable(true);
            jTextField_yAxis_TickLabel_yAlign.setEditable(true);
            jTextField_yAxis_TickLabel_Spacing.setEditable(true);
        }
        if (!plot_Marker_On) {
            jTextField_plot_Marker_Size.setEditable(false);
            jPanel_plot_Marker_Color.setVisible(false);
            jPanel_plot_Marker_FillColor.setVisible(false);
            jTextField_plot_Marker_Style1.setEditable(false);
            jTextField_plot_Marker_Style2.setEditable(false);
            jTextField_plot_Marker_Thickness.setEditable(false);
            jComboBox_plot_Marker_Type.setEditable(false);

        }
        else {
            jTextField_plot_Marker_Size.setEditable(true);
            jPanel_plot_Marker_Color.setVisible(true);
            jPanel_plot_Marker_FillColor.setVisible(true);
            jTextField_plot_Marker_Style1.setEditable(true);
            jTextField_plot_Marker_Style2.setEditable(true);
            jTextField_plot_Marker_Thickness.setEditable(true);
            jComboBox_plot_Marker_Type.setEditable(true);
        }

        if (!plot_Box_On) {
            jPanel_plot_Box_Color.setVisible(false);
            jPanel_plot_Box_FillColor.setVisible(false);
            jTextField_plot_Box_Size.setEditable(false);
            jTextField_plot_Box_Style1.setEditable(false);
            jTextField_plot_Box_Style2.setEditable(false);
            jTextField_plot_Box_Style3.setEditable(false);
            jTextField_plot_Box_Style4.setEditable(false);
            jTextField_plot_Box_Padding1.setEditable(false);
            jTextField_plot_Box_Padding2.setEditable(false);
            jTextField_plot_Box_Padding3.setEditable(false);
            jTextField_plot_Box_Padding4.setEditable(false);
        }
        else {
            jPanel_plot_Box_Color.setVisible(true);
            jPanel_plot_Box_FillColor.setVisible(true);
            jTextField_plot_Box_Size.setEditable(true);
            jTextField_plot_Box_Style1.setEditable(true);
            jTextField_plot_Box_Style2.setEditable(true);
            jTextField_plot_Box_Style3.setEditable(true);
            jTextField_plot_Box_Style4.setEditable(true);
            jTextField_plot_Box_Padding1.setEditable(true);
            jTextField_plot_Box_Padding2.setEditable(true);
            jTextField_plot_Box_Padding3.setEditable(true);
            jTextField_plot_Box_Padding4.setEditable(true);
        }

    }

    public void setSettings() {

        //Plot Title
        jTextField_plot_Title_Text.setText(plot_Title_Text);
        jPanel_plot_Title_Color.setBackground(plot_Title_Color);
        jComboBox_plot_Title_Font.setSelectedItem(plot_Title_Font);
        jTextField_plot_Title_FontSize.setText(String.valueOf(plot_Title_FontSize));
        jTextField_plot_Title_xAlign.setText(String.format(formatString, plot_Title_xAlign));
        jTextField_plot_Title_yAlign.setText(String.format(formatString, plot_Title_yAlign));

        //Plot Line
        jTextField_plot_Line_Size.setText(String.format(formatString, plot_Line_Size));
        jComboBox_plot_Line_Type.setSelectedItem(plot_Line_Type);
        jPanel_plot_Line_Color.setBackground(plot_Line_Color);
        jPanel_plot_Background_Color.setBackground(plot_Background_Color);
        jTextField_plot_Line_Style1.setText(String.format(formatString, plot_Line_Style1));
        jTextField_plot_Line_Style2.setText(String.format(formatString, plot_Line_Style2));
        jTextField_plot_Line_Style3.setText(String.format(formatString, plot_Line_Style3));
        jTextField_plot_Line_Style4.setText(String.format(formatString, plot_Line_Style4));

        //Plot Marker
        jCheckBox_plot_Marker_On.setSelected(plot_Marker_On);
        jTextField_plot_Marker_Size.setText(String.format(formatString, plot_Marker_Size));
        jComboBox_plot_Marker_Type.setSelectedItem(plot_Marker_Type);
        jPanel_plot_Marker_Color.setBackground(plot_Marker_Color);
        jPanel_plot_Marker_FillColor.setBackground(plot_Marker_FillColor);
        jTextField_plot_Marker_Style1.setText(String.format(formatString, plot_Marker_Style1));
        jTextField_plot_Marker_Style2.setText(String.format(formatString, plot_Marker_Style2));
        jTextField_plot_Marker_Thickness.setText(String.format(formatString, plot_Marker_Thickness));
//        jTextField_plot_Marker_Style3.setText(String.valueOf(plot_Marker_Style3));
//        jTextField_plot_Marker_Thickness.setText(String.valueOf(plot_Marker_Style4));


        //Plot Box
        jCheckBox_plot_Box_On.setSelected(plot_Box_On);
        jTextField_plot_Box_Padding1.setText(String.valueOf(plot_Box_Padding1));
        jTextField_plot_Box_Padding2.setText(String.valueOf(plot_Box_Padding2));
        jTextField_plot_Box_Padding3.setText(String.valueOf(plot_Box_Padding3));
        jTextField_plot_Box_Padding4.setText(String.valueOf(plot_Box_Padding4));
        jTextField_plot_Box_Size.setText(String.format(formatString, plot_Box_Size));
        jPanel_plot_Box_Color.setBackground(plot_Box_Color);
        jPanel_plot_Box_FillColor.setBackground(plot_Box_FillColor);
        jTextField_plot_Box_Style1.setText(String.format(formatString, plot_Box_Style1));
        jTextField_plot_Box_Style2.setText(String.format(formatString, plot_Box_Style2));
        jTextField_plot_Box_Style3.setText(String.format(formatString, plot_Box_Style3));
        jTextField_plot_Box_Style4.setText(String.format(formatString, plot_Box_Style4));


        //xAxis Label
        jTextField_xAxis_Label_Text.setText(xAxis_Label_Text);
        jPanel_xAxis_Label_Color.setBackground(xAxis_Label_Color);
        jComboBox_xAxis_Label_Font.setSelectedItem(xAxis_Label_Font);
        jTextField_xAxis_Label_FontSize.setText(String.valueOf(xAxis_Label_FontSize));
        jTextField_xAxis_Label_xAlign.setText(String.format(formatString, xAxis_Label_xAlign));
        jTextField_xAxis_Label_yAlign.setText(String.format(formatString, xAxis_Label_yAlign));

        //xAxis Axis
        jCheckBox_xAxis_Auto.setSelected(xAxis_Auto);
        jTextField_xAxis_Min.setText(String.format(formatString, xAxis_Min));
        jTextField_xAxis_Max.setText(String.format(formatString, xAxis_Max));

        //xAxis Line
        jTextField_xAxis_Line_Size.setText(String.format(formatString, xAxis_Line_Size));
        jPanel_xAxis_Line_Color.setBackground(xAxis_Line_Color);
        jTextField_xAxis_Line_Style1.setText(String.format(formatString, xAxis_Line_Style1));
        jTextField_xAxis_Line_Style2.setText(String.format(formatString, xAxis_Line_Style2));
        jTextField_xAxis_Line_Style3.setText(String.format(formatString, xAxis_Line_Style3));
        jTextField_xAxis_Line_Style4.setText(String.format(formatString, xAxis_Line_Style4));

        //xAxis Grid
        jCheckBox_xAxis_Grid_On.setSelected(xAxis_Grid_On);
        jPanel_xAxis_Grid_Color.setBackground(xAxis_Grid_Color);
        jTextField_xAxis_Grid_Size.setText(String.format(formatString, xAxis_Grid_Size));
        jTextField_xAxis_Grid_Spacing.setText(String.format(formatString, xAxis_Grid_Spacing));
        jTextField_xAxis_Grid_Style1.setText(String.format(formatString, xAxis_Grid_Style1));
        jTextField_xAxis_Grid_Style2.setText(String.format(formatString, xAxis_Grid_Style2));
        jTextField_xAxis_Grid_Style3.setText(String.format(formatString, xAxis_Grid_Style3));
        jTextField_xAxis_Grid_Style4.setText(String.format(formatString, xAxis_Grid_Style4));

        //xAxis TickMarks
        jCheckBox_xAxis_TickMarks_On.setSelected(xAxis_TickMarks_On);
        jTextField_xAxis_TickMarks_Size.setText(String.valueOf(xAxis_TickMarks_Size));
        jTextField_xAxis_TickMarks_Spacing.setText(String.format(formatString, xAxis_TickMarks_Spacing));
        jTextField_xAxis_TickMarks_Length.setText(String.format(formatString, xAxis_TickMarks_Length));
        jPanel_xAxis_TickMarks_Color.setBackground(xAxis_TickMarks_Color);

        //xAxis TickLabel
        jCheckBox_xAxis_TickLabel_On.setSelected(xAxis_TickLabel_On);
        jComboBox_xAxis_TickLabel_Font.setSelectedItem(xAxis_TickLabel_Font);
        jTextField_xAxis_TickLabel_FontSize.setText(String.valueOf(xAxis_TickLabel_FontSize));
        jPanel_xAxis_TickLabel_Color.setBackground(xAxis_TickLabel_Color);
        jTextField_xAxis_TickLabel_xAlign.setText(String.format(formatString, xAxis_TickLabel_xAlign));
        jTextField_xAxis_TickLabel_yAlign.setText(String.format(formatString, xAxis_TickLabel_yAlign));
        jTextField_xAxis_TickLabel_Spacing.setText(String.format(formatString, xAxis_TickLabel_Spacing));



        //yAxis Label
        jTextField_yAxis_Label_Text.setText(yAxis_Label_Text);
        jPanel_yAxis_Label_Color.setBackground(yAxis_Label_Color);
        jComboBox_yAxis_Label_Font.setSelectedItem(yAxis_Label_Font);
        jTextField_yAxis_Label_FontSize.setText(String.valueOf(yAxis_Label_FontSize));
        jTextField_yAxis_Label_xAlign.setText(String.format(formatString, yAxis_Label_xAlign));
        jTextField_yAxis_Label_yAlign.setText(String.format(formatString, yAxis_Label_yAlign));

        //yAxis Axis
        jCheckBox_yAxis_Auto.setSelected(yAxis_Auto);
        jTextField_yAxis_Min.setText(String.format(formatString, yAxis_Min));
        jTextField_yAxis_Max.setText(String.format(formatString, yAxis_Max));

        //yAxis Line
        jTextField_yAxis_Line_Size.setText(String.format(formatString, yAxis_Line_Size));
        jPanel_yAxis_Line_Color.setBackground(yAxis_Line_Color);
        jTextField_yAxis_Line_Style1.setText(String.format(formatString, yAxis_Line_Style1));
        jTextField_yAxis_Line_Style2.setText(String.format(formatString, yAxis_Line_Style2));
        jTextField_yAxis_Line_Style3.setText(String.format(formatString, yAxis_Line_Style3));
        jTextField_yAxis_Line_Style4.setText(String.format(formatString, yAxis_Line_Style4));

        //yAxis Grid
        jCheckBox_yAxis_Grid_On.setSelected(yAxis_Grid_On);
        jPanel_yAxis_Grid_Color.setBackground(yAxis_Grid_Color);
        jTextField_yAxis_Grid_Size.setText(String.format(formatString, yAxis_Grid_Size));
        jTextField_yAxis_Grid_Spacing.setText(String.format(formatString, yAxis_Grid_Spacing));
        jTextField_yAxis_Grid_Style1.setText(String.format(formatString, yAxis_Grid_Style1));
        jTextField_yAxis_Grid_Style2.setText(String.format(formatString, yAxis_Grid_Style2));
        jTextField_yAxis_Grid_Style3.setText(String.format(formatString, yAxis_Grid_Style3));
        jTextField_yAxis_Grid_Style4.setText(String.format(formatString, yAxis_Grid_Style4));

        //yAxis TickMarks
        jCheckBox_yAxis_TickMarks_On.setSelected(yAxis_TickMarks_On);
        jTextField_yAxis_TickMarks_Size.setText(String.valueOf(yAxis_TickMarks_Size));
        jTextField_yAxis_TickMarks_Spacing.setText(String.format(formatString, yAxis_TickMarks_Spacing));
        jTextField_yAxis_TickMarks_Length.setText(String.format(formatString, yAxis_TickMarks_Length));
        jPanel_yAxis_TickMarks_Color.setBackground(yAxis_TickMarks_Color);

        //yAxis TickLabel
        jCheckBox_yAxis_TickLabel_On.setSelected(yAxis_TickLabel_On);
        jComboBox_yAxis_TickLabel_Font.setSelectedItem(yAxis_TickLabel_Font);
        jTextField_yAxis_TickLabel_FontSize.setText(String.valueOf(yAxis_TickLabel_FontSize));
        jPanel_yAxis_TickLabel_Color.setBackground(yAxis_TickLabel_Color);
        jTextField_yAxis_TickLabel_xAlign.setText(String.format(formatString, yAxis_TickLabel_xAlign));
        jTextField_yAxis_TickLabel_yAlign.setText(String.format(formatString, yAxis_TickLabel_yAlign));
        jTextField_yAxis_TickLabel_Spacing.setText(String.format(formatString, yAxis_TickLabel_Spacing));

        setAxisAuto();
        setXYGridOn();
    }

    public void getNewSettings() {

        //Plot Title
        plot_Title_Text = jTextField_plot_Title_Text.getText();
        plot_Title_Color = jPanel_plot_Title_Color.getBackground();
        plot_Title_Font = (String) jComboBox_plot_Title_Font.getSelectedItem();
        plot_Title_FontSize = Integer.parseInt(jTextField_plot_Title_FontSize.getText());
        plot_Title_xAlign = Float.parseFloat(jTextField_plot_Title_xAlign.getText());
        plot_Title_yAlign = Float.parseFloat(jTextField_plot_Title_yAlign.getText());

        //Plot Line
        plot_Line_Size = Float.parseFloat(jTextField_plot_Line_Size.getText());
        plot_Line_Type = (String) jComboBox_plot_Line_Type.getSelectedItem();
        plot_Line_Color = jPanel_plot_Line_Color.getBackground();
        plot_Background_Color = jPanel_plot_Background_Color.getBackground();
        plot_Line_Style1 = Float.parseFloat(jTextField_plot_Line_Style1.getText());
        plot_Line_Style2 = Float.parseFloat(jTextField_plot_Line_Style2.getText());
        plot_Line_Style3 = Float.parseFloat(jTextField_plot_Line_Style3.getText());
        plot_Line_Style4 = Float.parseFloat(jTextField_plot_Line_Style4.getText());

        //Plot Marker
        plot_Marker_On = jCheckBox_plot_Marker_On.isSelected();
        plot_Marker_Size = Float.parseFloat(jTextField_plot_Marker_Size.getText());
        plot_Marker_Type = (String) jComboBox_plot_Marker_Type.getSelectedItem();
        plot_Marker_Color = jPanel_plot_Marker_Color.getBackground();
        plot_Marker_FillColor = jPanel_plot_Marker_FillColor.getBackground();
        plot_Marker_Style1 = Float.parseFloat(jTextField_plot_Marker_Style1.getText());
        plot_Marker_Style2 = Float.parseFloat(jTextField_plot_Marker_Style2.getText());
        plot_Marker_Thickness = Float.parseFloat(jTextField_plot_Marker_Thickness.getText());
//        plot_Marker_Style3 = Float.parseFloat(jTextField_plot_Marker_Style3.getText());
//        plot_Marker_Style4 = Float.parseFloat(jTextField_plot_Marker_Thickness.getText());

        //Plot Box
        plot_Box_On = jCheckBox_plot_Box_On.isSelected();
        plot_Box_Padding1 = Integer.parseInt(jTextField_plot_Box_Padding1.getText());
        plot_Box_Padding2 = Integer.parseInt(jTextField_plot_Box_Padding2.getText());
        plot_Box_Padding3 = Integer.parseInt(jTextField_plot_Box_Padding3.getText());
        plot_Box_Padding4 = Integer.parseInt(jTextField_plot_Box_Padding4.getText());

        plot_Box_Size = Float.parseFloat(jTextField_plot_Box_Size.getText());
        plot_Box_Color = jPanel_plot_Box_Color.getBackground();
        plot_Box_FillColor = jPanel_plot_Box_FillColor.getBackground();
        plot_Box_Style1 = Float.parseFloat(jTextField_plot_Box_Style1.getText());
        plot_Box_Style2 = Float.parseFloat(jTextField_plot_Box_Style2.getText());
        plot_Box_Style3 = Float.parseFloat(jTextField_plot_Box_Style3.getText());
        plot_Box_Style4 = Float.parseFloat(jTextField_plot_Box_Style4.getText());


        //xAxis Label
        xAxis_Label_Text = jTextField_xAxis_Label_Text.getText();
        xAxis_Label_Color = jPanel_xAxis_Label_Color.getBackground();
        xAxis_Label_Font = (String) jComboBox_xAxis_Label_Font.getSelectedItem();
        xAxis_Label_FontSize = Integer.parseInt(jTextField_xAxis_Label_FontSize.getText());
        xAxis_Label_xAlign = Float.parseFloat(jTextField_xAxis_Label_xAlign.getText());
        xAxis_Label_yAlign = Float.parseFloat(jTextField_xAxis_Label_yAlign.getText());

        //xAxis Axis
        xAxis_Auto = jCheckBox_xAxis_Auto.isSelected();
        xAxis_Min = Float.parseFloat(jTextField_xAxis_Min.getText());
        xAxis_Max = Float.parseFloat(jTextField_xAxis_Max.getText());

        //xAxis Line
        xAxis_Line_Size = Float.parseFloat(jTextField_xAxis_Line_Size.getText());
        xAxis_Line_Color = jPanel_xAxis_Line_Color.getBackground();
        xAxis_Line_Style1 = Float.parseFloat(jTextField_xAxis_Line_Style1.getText());
        xAxis_Line_Style2 = Float.parseFloat(jTextField_xAxis_Line_Style2.getText());
        xAxis_Line_Style3 = Float.parseFloat(jTextField_xAxis_Line_Style3.getText());
        xAxis_Line_Style4 = Float.parseFloat(jTextField_xAxis_Line_Style4.getText());

        //xAxis Grid
        xAxis_Grid_On = jCheckBox_xAxis_Grid_On.isSelected();
        xAxis_Grid_Color = jPanel_xAxis_Grid_Color.getBackground();
        xAxis_Grid_Size = Float.parseFloat(jTextField_xAxis_Grid_Size.getText());
        xAxis_Grid_Spacing = Float.parseFloat(jTextField_xAxis_Grid_Spacing.getText());
        xAxis_Grid_Style1 = Float.parseFloat(jTextField_xAxis_Grid_Style1.getText());
        xAxis_Grid_Style2 = Float.parseFloat(jTextField_xAxis_Grid_Style2.getText());
        xAxis_Grid_Style3 = Float.parseFloat(jTextField_xAxis_Grid_Style3.getText());
        xAxis_Grid_Style4 = Float.parseFloat(jTextField_xAxis_Grid_Style4.getText());

        //xAxis TickMarks
        xAxis_TickMarks_On = jCheckBox_xAxis_TickMarks_On.isSelected();
        xAxis_TickMarks_Size = Integer.parseInt(jTextField_xAxis_TickMarks_Size.getText());
        xAxis_TickMarks_Spacing = Float.parseFloat(jTextField_xAxis_TickMarks_Spacing.getText());
        xAxis_TickMarks_Length = Float.parseFloat(jTextField_xAxis_TickMarks_Length.getText());
        xAxis_TickMarks_Color = jPanel_xAxis_TickMarks_Color.getBackground();

        //xAxis TickLabel
        xAxis_TickLabel_On = jCheckBox_xAxis_TickLabel_On.isSelected();
        xAxis_TickLabel_Font = (String) jComboBox_xAxis_TickLabel_Font.getSelectedItem();
        xAxis_TickLabel_FontSize = Integer.parseInt(jTextField_xAxis_TickLabel_FontSize.getText());
        xAxis_TickLabel_Color = jPanel_xAxis_TickLabel_Color.getBackground();
        xAxis_TickLabel_xAlign = Float.parseFloat(jTextField_xAxis_TickLabel_xAlign.getText());
        xAxis_TickLabel_yAlign = Float.parseFloat(jTextField_xAxis_TickLabel_yAlign.getText());
        xAxis_TickLabel_Spacing = Float.parseFloat(jTextField_xAxis_TickLabel_Spacing.getText());


        //yAxis Label
        yAxis_Label_Text = jTextField_yAxis_Label_Text.getText();
        yAxis_Label_Color = jPanel_yAxis_Label_Color.getBackground();
        yAxis_Label_Font = (String) jComboBox_yAxis_Label_Font.getSelectedItem();
        yAxis_Label_FontSize = Integer.parseInt(jTextField_yAxis_Label_FontSize.getText());
        yAxis_Label_xAlign = Float.parseFloat(jTextField_yAxis_Label_xAlign.getText());
        yAxis_Label_yAlign = Float.parseFloat(jTextField_yAxis_Label_yAlign.getText());

        //yAxis Axis
        yAxis_Auto = jCheckBox_yAxis_Auto.isSelected();
        yAxis_Min = Float.parseFloat(jTextField_yAxis_Min.getText());
        yAxis_Max = Float.parseFloat(jTextField_yAxis_Max.getText());

        //yAxis Line
        yAxis_Line_Size = Float.parseFloat(jTextField_yAxis_Line_Size.getText());
        yAxis_Line_Color = jPanel_yAxis_Line_Color.getBackground();
        yAxis_Line_Style1 = Float.parseFloat(jTextField_yAxis_Line_Style1.getText());
        yAxis_Line_Style2 = Float.parseFloat(jTextField_yAxis_Line_Style2.getText());
        yAxis_Line_Style3 = Float.parseFloat(jTextField_yAxis_Line_Style3.getText());
        yAxis_Line_Style4 = Float.parseFloat(jTextField_yAxis_Line_Style4.getText());

        //yAxis Grid
        yAxis_Grid_On = jCheckBox_yAxis_Grid_On.isSelected();
        yAxis_Grid_Color = jPanel_yAxis_Grid_Color.getBackground();
        yAxis_Grid_Size = Float.parseFloat(jTextField_yAxis_Grid_Size.getText());
        yAxis_Grid_Spacing = Float.parseFloat(jTextField_yAxis_Grid_Spacing.getText());
        yAxis_Grid_Style1 = Float.parseFloat(jTextField_yAxis_Grid_Style1.getText());
        yAxis_Grid_Style2 = Float.parseFloat(jTextField_yAxis_Grid_Style2.getText());
        yAxis_Grid_Style3 = Float.parseFloat(jTextField_yAxis_Grid_Style3.getText());
        yAxis_Grid_Style4 = Float.parseFloat(jTextField_yAxis_Grid_Style4.getText());

        //yAxis TickMarks
        yAxis_TickMarks_On = jCheckBox_yAxis_TickMarks_On.isSelected();
        yAxis_TickMarks_Size = Integer.parseInt(jTextField_yAxis_TickMarks_Size.getText());
        yAxis_TickMarks_Spacing = Float.parseFloat(jTextField_yAxis_TickMarks_Spacing.getText());
        yAxis_TickMarks_Length = Float.parseFloat(jTextField_yAxis_TickMarks_Length.getText());
        yAxis_TickMarks_Color = jPanel_yAxis_TickMarks_Color.getBackground();

        //yAxis TickLabel
        yAxis_TickLabel_On = jCheckBox_yAxis_TickLabel_On.isSelected();
        yAxis_TickLabel_Font = (String) jComboBox_yAxis_TickLabel_Font.getSelectedItem();
        yAxis_TickLabel_FontSize = Integer.parseInt(jTextField_yAxis_TickLabel_FontSize.getText());
        yAxis_TickLabel_Color = jPanel_yAxis_TickLabel_Color.getBackground();
        yAxis_TickLabel_xAlign = Float.parseFloat(jTextField_yAxis_TickLabel_xAlign.getText());
        yAxis_TickLabel_yAlign = Float.parseFloat(jTextField_yAxis_TickLabel_yAlign.getText());
        yAxis_TickLabel_Spacing = Float.parseFloat(jTextField_yAxis_TickLabel_Spacing.getText());

    }

    //Plot
    public void setPlot_Title_Text(String textGiven) {
        plot_Title_Text = textGiven;
    }

    public void setPlot_Title_Color(Color colorGiven) {
        plot_Title_Color = colorGiven;
    }

    public void setPlot_Title_Font(String fontGiven) {
        plot_Title_Font = fontGiven;
    }

    public void setPlot_Title_FontSize(int fontSizeGiven) {
        plot_Title_FontSize = fontSizeGiven;
    }

    public void setPlot_Title_xAlign(float xAlignGiven) {
        plot_Title_xAlign = xAlignGiven;
    }

    public void setPlot_Title_yAlign(float yAlignGiven) {
        plot_Title_yAlign = yAlignGiven;
    }

    public void setPlot_Line_Size(float sizeGiven) {
        plot_Line_Size = sizeGiven;
    }

    public void setPlot_Line_Type(String textGiven) {
        plot_Line_Type = textGiven;
    }

    public void setPlot_Line_Color(Color colorGiven) {
        plot_Line_Color = colorGiven;
    }

    public void setPlot_Background_Color(Color colorGiven) {
        plot_Background_Color = colorGiven;
    }

    public void setPlot_Line_Style(float[] styleGiven) {
        plot_Line_Style1 = styleGiven[0];
        plot_Line_Style2 = styleGiven[1];
        plot_Line_Style3 = styleGiven[2];
        plot_Line_Style4 = styleGiven[3];
    }

    public void setPlot_Line_Style1(float styleGiven) {
        plot_Line_Style1 = styleGiven;
    }

    public void setPlot_Line_Style2(float styleGiven) {
        plot_Line_Style2 = styleGiven;
    }

    public void setPlot_Line_Style3(float styleGiven) {
        plot_Line_Style3 = styleGiven;
    }

    public void setPlot_Line_Style4(float styleGiven) {
        plot_Line_Style4 = styleGiven;
    }

    public void setPlot_Marker_On(boolean markerOnGiven) {
        plot_Marker_On = markerOnGiven;
    }

    public void setPlot_Marker_Size(float sizeGiven) {
        plot_Marker_Size = sizeGiven;
    }

    public void setPlot_Marker_Type(String typeGiven) {
        plot_Marker_Type = typeGiven;
    }

    public void setPlot_Marker_Color(Color colorGiven) {
        plot_Marker_Color = colorGiven;
    }

    public void setPlot_Marker_FillColor(Color colorGiven) {
        plot_Marker_FillColor = colorGiven;
    }

    public void setPlot_Marker_Style1(float styleGiven) {
        plot_Marker_Style1 = styleGiven;
    }

    public void setPlot_Marker_Style2(float styleGiven) {
        plot_Marker_Style2 = styleGiven;
    }

    public void setPlot_Marker_Thickness(float thicknessGiven) {
        plot_Marker_Thickness = thicknessGiven;
    }


//    public void setPlot_Marker_Style3(float styleGiven) {
//        plot_Marker_Style3 = styleGiven;
//    }
//
//    public void setPlot_Marker_Style4(float styleGiven) {
//        plot_Marker_Style4 = styleGiven;
//    }
    public void setPlot_Box_On(boolean onGiven) {
        plot_Box_On = onGiven;
    }

    public void setPlot_Box_Padding1(int paddingGiven) {
        plot_Box_Padding1 = paddingGiven;
    }

    public void setPlot_Box_Padding2(int paddingGiven) {
        plot_Box_Padding2 = paddingGiven;
    }

    public void setPlot_Box_Padding3(int paddingGiven) {
        plot_Box_Padding3 = paddingGiven;
    }

    public void setPlot_Box_Padding4(int paddingGiven) {
        plot_Box_Padding4 = paddingGiven;
    }

    public void setPlot_Box_Size(float sizeGiven) {
        plot_Box_Size = sizeGiven;
    }

    public void setPlot_Box_Color(Color colorGiven) {
        plot_Box_Color = colorGiven;
    }

    public void setPlot_Box_FillColor(Color colorGiven) {
        plot_Box_FillColor = colorGiven;
    }

    public void setPlot_Box_Style(float[] styleGiven) {
        plot_Box_Style1 = styleGiven[0];
        plot_Box_Style2 = styleGiven[1];
        plot_Box_Style3 = styleGiven[2];
        plot_Box_Style4 = styleGiven[3];
    }

    public void setPlot_Box_Style1(float styleGiven) {
        plot_Box_Style1 = styleGiven;
    }

    public void setPlot_Box_Style2(float styleGiven) {
        plot_Box_Style2 = styleGiven;
    }

    public void setPlot_Box_Style3(float styleGiven) {
        plot_Box_Style3 = styleGiven;
    }

    public void setPlot_Box_Style4(float styleGiven) {
        plot_Box_Style4 = styleGiven;
    }

    //xAxis
    public void setXAxis_Label_Text(String textGiven) {
        xAxis_Label_Text = textGiven;
    }

    public void setXAxis_Label_Color(Color colorGiven) {
        xAxis_Label_Color = colorGiven;
    }

    public void setXAxis_Label_Font(String fontGiven) {
        xAxis_Label_Font = fontGiven;
    }

    public void setXAxis_Label_FontSize(int fontSizeGiven) {
        xAxis_Label_FontSize = fontSizeGiven;
    }

    public void setXAxis_Label_xAlign(float xAlignGiven) {
        xAxis_Label_xAlign = xAlignGiven;
    }

    public void setXAxis_Label_yAlign(float yAlignGiven) {
        xAxis_Label_yAlign = yAlignGiven;
    }

    public void setXAxis_Auto(boolean autoGiven) {
        xAxis_Auto = autoGiven;
    }

    public void setXAxis_Limits(float xMinGiven, float xMaxGiven) {
        xAxis_Min = xMinGiven;
        xAxis_Max = xMaxGiven;
    }

    public void setXAxis_Min(float xMinGiven) {
        xAxis_Min = xMinGiven;
    }

    public void setXAxis_Max(float xMaxGiven) {
        xAxis_Max = xMaxGiven;
    }

    public void setXAxis_Line_Size(float sizeGiven) {
        xAxis_Line_Size = sizeGiven;
    }

    public void setXAxis_Line_Color(Color colorGiven) {
        xAxis_Line_Color = colorGiven;
    }

    public void setXAxis_Line_Style(float[] styleGiven) {
        xAxis_Line_Style1 = styleGiven[0];
        xAxis_Line_Style2 = styleGiven[1];
        xAxis_Line_Style3 = styleGiven[2];
        xAxis_Line_Style4 = styleGiven[3];
    }

    public void setXAxis_Line_Style1(float styleGiven) {
        xAxis_Line_Style1 = styleGiven;
    }

    public void setXAxis_Line_Style2(float styleGiven) {
        xAxis_Line_Style2 = styleGiven;
    }

    public void setXAxis_Line_Style3(float styleGiven) {
        xAxis_Line_Style3 = styleGiven;
    }

    public void setXAxis_Line_Style4(float styleGiven) {
        xAxis_Line_Style4 = styleGiven;
    }

    public void setXAxis_Grid_On(boolean gridOnGiven) {
        xAxis_Grid_On = gridOnGiven;
    }

    public void setXAxis_Grid_Color(Color colorGiven) {
        xAxis_Grid_Color = colorGiven;
    }

    public void setXAxis_Grid_Size(float sizeGiven) {
        xAxis_Grid_Size = sizeGiven;
    }

    public void setXAxis_Grid_Spacing(float spacingGiven) {
        xAxis_Grid_Spacing = spacingGiven;
    }

    public void setXAxis_Grid_Style(float[] styleGiven) {
        xAxis_Grid_Style1 = styleGiven[0];
        xAxis_Grid_Style2 = styleGiven[1];
        xAxis_Grid_Style3 = styleGiven[2];
        xAxis_Grid_Style4 = styleGiven[3];
    }

    public void setXAxis_Grid_Style1(float styleGiven) {
        xAxis_Grid_Style1 = styleGiven;
    }

    public void setXAxis_Grid_Style2(float styleGiven) {
        xAxis_Grid_Style2 = styleGiven;
    }

    public void setXAxis_Grid_Style3(float styleGiven) {
        xAxis_Grid_Style3 = styleGiven;
    }

    public void setXAxis_Grid_Style4(float styleGiven) {
        xAxis_Grid_Style4 = styleGiven;
    }

    public void setXAxis_TickMarks_On(boolean onGiven) {
        xAxis_TickMarks_On = onGiven;
    }

    public void setXAxis_TickMarks_Size(int sizeGiven) {
        xAxis_TickMarks_Size = sizeGiven;
    }

    public void setXAxis_TickMarks_Spacing(float spacingGiven) {
        xAxis_TickMarks_Spacing = spacingGiven;
    }

    public void setXAxis_TickMarks_Length(float lengthGiven) {
        xAxis_TickMarks_Length = lengthGiven;
    }

    public void setXAxis_TickMarks_Color(Color colorGiven) {
        xAxis_TickMarks_Color = colorGiven;
    }

    public void setXAxis_TickLabel_On(boolean onGiven) {
        xAxis_TickLabel_On = onGiven;
    }

    public void setXAxis_TickLabel_Font(String fontGiven) {
        xAxis_TickLabel_Font = fontGiven;
    }

    public void setXAxis_TickLabel_FontSize(int fontSizeGiven) {
        xAxis_TickLabel_FontSize = fontSizeGiven;
    }

    public void setXAxis_TickLabel_Color(Color colorGiven) {
        xAxis_TickLabel_Color = colorGiven;
    }

    public void setXAxis_TickLabel_xAlign(float xAlignGiven) {
        xAxis_TickLabel_xAlign = xAlignGiven;
    }

    public void setXAxis_TickLabel_yAlign(float yAlignGiven) {
        xAxis_TickLabel_yAlign = yAlignGiven;
    }

    public void setXAxis_TickLabel_Spacing(float spacingGiven) {
        xAxis_TickLabel_Spacing = spacingGiven;
    }

    //yAxis
    public void setYAxis_Label_Text(String textGiven) {
        yAxis_Label_Text = textGiven;
    }

    public void setYAxis_Label_Color(Color colorGiven) {
        yAxis_Label_Color = colorGiven;
    }

    public void setYAxis_Label_Font(String fontGiven) {
        yAxis_Label_Font = fontGiven;
    }

    public void setYAxis_Label_FontSize(int fontSizeGiven) {
        yAxis_Label_FontSize = fontSizeGiven;
    }

    public void setYAxis_Label_xAlign(float xAlignGiven) {
        yAxis_Label_xAlign = xAlignGiven;
    }

    public void setYAxis_Label_yAlign(float yAlignGiven) {
        yAxis_Label_yAlign = yAlignGiven;
    }

    public void setYAxis_Auto(boolean autoGiven) {
        yAxis_Auto = autoGiven;
    }

    public void setYAxis_Limits(float yMinGiven, float yMaxGiven) {
        yAxis_Min = yMinGiven;
        yAxis_Max = yMaxGiven;
    }

    public void setYAxis_Min(float yMinGiven) {
        yAxis_Min = yMinGiven;
    }

    public void setYAxis_Max(float yMaxGiven) {
        yAxis_Max = yMaxGiven;
    }

    public void setYAxis_Line_Size(float sizeGiven) {
        yAxis_Line_Size = sizeGiven;
    }

    public void setYAxis_Line_Color(Color colorGiven) {
        yAxis_Line_Color = colorGiven;
    }

    public void setYAxis_Line_Style(float[] styleGiven) {
        yAxis_Line_Style1 = styleGiven[0];
        yAxis_Line_Style2 = styleGiven[1];
        yAxis_Line_Style3 = styleGiven[2];
        yAxis_Line_Style4 = styleGiven[3];
    }

    public void setYAxis_Line_Style1(float styleGiven) {
        yAxis_Line_Style1 = styleGiven;
    }

    public void setYAxis_Line_Style2(float styleGiven) {
        yAxis_Line_Style2 = styleGiven;
    }

    public void setYAxis_Line_Style3(float styleGiven) {
        yAxis_Line_Style3 = styleGiven;
    }

    public void setYAxis_Line_Style4(float styleGiven) {
        yAxis_Line_Style4 = styleGiven;
    }

    public void setYAxis_Grid_On(boolean gridOnGiven) {
        yAxis_Grid_On = gridOnGiven;
    }

    public void setYAxis_Grid_Color(Color colorGiven) {
        yAxis_Grid_Color = colorGiven;
    }

    public void setYAxis_Grid_Size(float sizeGiven) {
        yAxis_Grid_Size = sizeGiven;
    }

    public void setYAxis_Grid_Spacing(float spacingGiven) {
        yAxis_Grid_Spacing = spacingGiven;
    }

    public void setYAxis_Grid_Style(float[] styleGiven) {
        yAxis_Grid_Style1 = styleGiven[0];
        yAxis_Grid_Style2 = styleGiven[1];
        yAxis_Grid_Style3 = styleGiven[2];
        yAxis_Grid_Style4 = styleGiven[3];
    }

    public void setYAxis_Grid_Style1(float styleGiven) {
        yAxis_Grid_Style1 = styleGiven;
    }

    public void setYAxis_Grid_Style2(float styleGiven) {
        yAxis_Grid_Style2 = styleGiven;
    }

    public void setYAxis_Grid_Style3(float styleGiven) {
        yAxis_Grid_Style3 = styleGiven;
    }

    public void setYAxis_Grid_Style4(float styleGiven) {
        yAxis_Grid_Style4 = styleGiven;
    }

    public void setYAxis_TickMarks_On(boolean onGiven) {
        yAxis_TickMarks_On = onGiven;
    }

    public void setYAxis_TickMarks_Size(int sizeGiven) {
        yAxis_TickMarks_Size = sizeGiven;
    }

    public void setYAxis_TickMarks_Spacing(float spacingGiven) {
        yAxis_TickMarks_Spacing = spacingGiven;
    }

    public void setYAxis_TickMarks_Length(float lengthGiven) {
        yAxis_TickMarks_Length = lengthGiven;
    }

    public void setYAxis_TickMarks_Color(Color colorGiven) {
        yAxis_TickMarks_Color = colorGiven;
    }

    public void setYAxis_TickLabel_On(boolean onGiven) {
        yAxis_TickLabel_On = onGiven;
    }

    public void setYAxis_TickLabel_Font(String fontGiven) {
        yAxis_TickLabel_Font = fontGiven;
    }

    public void setYAxis_TickLabel_FontSize(int fontSizeGiven) {
        yAxis_TickLabel_FontSize = fontSizeGiven;
    }

    public void setYAxis_TickLabel_Color(Color colorGiven) {
        yAxis_TickLabel_Color = colorGiven;
    }

    public void setYAxis_TickLabel_xAlign(float xAlignGiven) {
        yAxis_TickLabel_xAlign = xAlignGiven;
    }

    public void setYAxis_TickLabel_yAlign(float yAlignGiven) {
        yAxis_TickLabel_yAlign = yAlignGiven;
    }

    public void setYAxis_TickLabel_Spacing(float spacingGiven) {
        yAxis_TickLabel_Spacing = spacingGiven;
    }

    public void setXYAxis_Limits(float xMinGiven, float xMaxGiven, float yMinGiven, float yMaxGiven) {
        xAxis_Min = xMinGiven;
        xAxis_Max = xMaxGiven;
        yAxis_Min = yMinGiven;
        yAxis_Max = yMaxGiven;
    }

    //Plot
    public String getPlot_Title_Text() {
        return plot_Title_Text;
    }

    public Color getPlot_Title_Color() {
        return plot_Title_Color;
    }

    public String getPlot_Title_Font() {
        return plot_Title_Font;
    }

    public int getPlot_Title_FontSize() {
        return plot_Title_FontSize;
    }

    public float getPlot_Title_xAlign() {
        return plot_Title_xAlign;
    }

    public float getPlot_Title_yAlign() {
        return plot_Title_yAlign;
    }

    public float getPlot_Line_Size() {
        return plot_Line_Size;
    }

    public String getPlot_Line_Type() {
        return plot_Line_Type;
    }

    public Color getPlot_Line_Color() {
        return plot_Line_Color;
    }

    public Color getPlot_Background_Color() {
        return plot_Background_Color;
    }

    public float[] getPlot_Line_Style() {
        float[] plotLineStyle = new float[4];
        plotLineStyle[0] = plot_Line_Style1;
        plotLineStyle[1] = plot_Line_Style2;
        plotLineStyle[2] = plot_Line_Style3;
        plotLineStyle[3] = plot_Line_Style4;
        return plotLineStyle;
    }

    public float getPlot_Line_Style1() {
        return plot_Line_Style1;
    }

    public float getPlot_Line_Style2() {
        return plot_Line_Style2;
    }

    public float getPlot_Line_Style3() {
        return plot_Line_Style3;
    }

    public float getPlot_Line_Style4() {
        return plot_Line_Style4;
    }

    public boolean getPlot_Marker_On() {
        return plot_Marker_On;
    }

    public float getPlot_Marker_Size() {
        return plot_Marker_Size;
    }

    public String getPlot_Marker_Type() {
        return plot_Marker_Type;
    }

    public Color getPlot_Marker_Color() {
        return plot_Marker_Color;
    }

    public Color getPlot_Marker_FillColor() {
        return plot_Marker_FillColor;
    }

    public float getPlot_Marker_Style1() {
        return plot_Marker_Style1;
    }

    public float getPlot_Marker_Style2() {
        return plot_Marker_Style2;
    }

    public float getPlot_Marker_Thickness() {
        return plot_Marker_Thickness;
    }


//    public float getPlot_Marker_Style3() {
//        return plot_Marker_Style3;
//    }
//
//    public float getPlot_Marker_Style4() {
//        return plot_Marker_Style4;
//    }
    public boolean getPlot_Box_On() {
        return plot_Box_On;
    }

    public int getPlot_Box_Padding1() {
        return plot_Box_Padding1;
    }

    public int getPlot_Box_Padding2() {
        return plot_Box_Padding2;
    }

    public int getPlot_Box_Padding3() {
        return plot_Box_Padding3;
    }

    public int getPlot_Box_Padding4() {
        return plot_Box_Padding4;
    }

    public float getPlot_Box_Size() {
        return plot_Box_Size;
    }

    public Color getPlot_Box_Color() {
        return plot_Box_Color;
    }

    public Color getPlot_Box_FillColor() {
        return plot_Box_FillColor;
    }

    public float[] getPlot_Box_Style() {
        float[] plotLineStyle = new float[4];
        plotLineStyle[0] = plot_Box_Style1;
        plotLineStyle[1] = plot_Box_Style2;
        plotLineStyle[2] = plot_Box_Style3;
        plotLineStyle[3] = plot_Box_Style4;
        return plotLineStyle;
    }

    public float getPlot_Box_Style1() {
        return plot_Box_Style1;
    }

    public float getPlot_Box_Style2() {
        return plot_Box_Style2;
    }

    public float getPlot_Box_Style3() {
        return plot_Box_Style3;
    }

    public float getPlot_Box_Style4() {
        return plot_Box_Style4;
    }

    //xAxis
    public String getXAxis_Label_Text() {
        return xAxis_Label_Text;
    }

    public Color getXAxis_Label_Color() {
        return xAxis_Label_Color;
    }

    public String getXAxis_Label_Font() {
        return xAxis_Label_Font;
    }

    public int getXAxis_Label_FontSize() {
        return xAxis_Label_FontSize;
    }

    public float getXAxis_Label_xAlign() {
        return xAxis_Label_xAlign;
    }

    public float getXAxis_Label_yAlign() {
        return xAxis_Label_yAlign;
    }

    public boolean getXAxis_Auto() {
        return xAxis_Auto;
    }

    public float[] getXAxis_Limits() {
        float[] xAxisLimits = new float[2];
        xAxisLimits[0] = xAxis_Min;
        xAxisLimits[1] = xAxis_Max;
        return xAxisLimits;
    }

    public float getXAxis_Min() {
        return xAxis_Min;
    }

    public float getXAxis_Max() {
        return xAxis_Max;
    }

    public float getXAxis_Line_Size() {
        return xAxis_Line_Size;
    }

    public Color getXAxis_Line_Color() {
        return xAxis_Line_Color;
    }

    public float[] getXAxis_Line_Style() {
        float[] xAxis_Line_Style = new float[4];
        xAxis_Line_Style[0] = xAxis_Line_Style1;
        xAxis_Line_Style[1] = xAxis_Line_Style2;
        xAxis_Line_Style[2] = xAxis_Line_Style3;
        xAxis_Line_Style[3] = xAxis_Line_Style4;
        return xAxis_Line_Style;
    }

    public float getXAxis_Line_Style1() {
        return xAxis_Line_Style1;
    }

    public float getXAxis_Line_Style2() {
        return xAxis_Line_Style2;
    }

    public float getXAxis_Line_Style3() {
        return xAxis_Line_Style3;
    }

    public float getXAxis_Line_Style4() {
        return xAxis_Line_Style4;
    }

    public boolean getXAxis_Grid_On() {
        return xAxis_Grid_On;
    }

    public Color getXAxis_Grid_Color() {
        return xAxis_Grid_Color;
    }

    public float getXAxis_Grid_Size() {
        return xAxis_Grid_Size;
    }

    public float getXAxis_Grid_Spacing() {
        return xAxis_Grid_Spacing;
    }

    public float[] getXAxis_Grid_Style() {
        float[] xAxis_Grid_Style = new float[4];
        xAxis_Grid_Style[0] = xAxis_Grid_Style1;
        xAxis_Grid_Style[1] = xAxis_Grid_Style2;
        xAxis_Grid_Style[2] = xAxis_Grid_Style3;
        xAxis_Grid_Style[3] = xAxis_Grid_Style4;
        return xAxis_Grid_Style;
    }

    public float getXAxis_Grid_Style1() {
        return xAxis_Grid_Style1;
    }

    public float getXAxis_Grid_Style2() {
        return xAxis_Grid_Style2;
    }

    public float getXAxis_Grid_Style3() {
        return xAxis_Grid_Style3;
    }

    public float getXAxis_Grid_Style4() {
        return xAxis_Grid_Style4;
    }

    public boolean getXAxis_TickMarks_On() {
        return xAxis_TickMarks_On;
    }

    public int getXAxis_TickMarks_Size() {
        return xAxis_TickMarks_Size;
    }

    public float getXAxis_TickMarks_Spacing() {
        return xAxis_TickMarks_Spacing;
    }

    public float getXAxis_TickMarks_Length() {
        return xAxis_TickMarks_Length;
    }

    public Color getXAxis_TickMarks_Color() {
        return xAxis_TickMarks_Color;
    }

    public boolean getXAxis_TickLabel_On() {
        return xAxis_TickLabel_On;
    }

    public String getXAxis_TickLabel_Font() {
        return xAxis_TickLabel_Font;
    }

    public int getXAxis_TickLabel_FontSize() {
        return xAxis_TickLabel_FontSize;
    }

    public Color getXAxis_TickLabel_Color() {
        return xAxis_TickLabel_Color;
    }

    public float getXAxis_TickLabel_xAlign() {
        return xAxis_TickLabel_xAlign;
    }

    public float getXAxis_TickLabel_yAlign() {
        return xAxis_TickLabel_yAlign;
    }

    public float getXAxis_TickLabel_Spacing() {
        return xAxis_TickLabel_Spacing;
    }


    //yAxis
    public String getYAxis_Label_Text() {
        return yAxis_Label_Text;
    }

    public Color getYAxis_Label_Color() {
        return yAxis_Label_Color;
    }

    public String getYAxis_Label_Font() {
        return yAxis_Label_Font;
    }

    public int getYAxis_Label_FontSize() {
        return yAxis_Label_FontSize;
    }

    public float getYAxis_Label_xAlign() {
        return yAxis_Label_xAlign;
    }

    public float getYAxis_Label_yAlign() {
        return yAxis_Label_yAlign;
    }

    public boolean getYAxis_Auto() {
        return yAxis_Auto;
    }

    public float[] getYAxis_Limits() {
        float[] yAxisLimits = new float[2];
        yAxisLimits[0] = yAxis_Min;
        yAxisLimits[1] = yAxis_Max;
        return yAxisLimits;
    }

    public float getYAxis_Min() {
        return yAxis_Min;
    }

    public float getYAxis_Max() {
        return yAxis_Max;
    }

    public float getYAxis_Line_Size() {
        return yAxis_Line_Size;
    }

    public Color getYAxis_Line_Color() {
        return yAxis_Line_Color;
    }

    public float[] getYAxis_Line_Style() {
        float[] yAxis_Line_Style = new float[4];
        yAxis_Line_Style[0] = yAxis_Line_Style1;
        yAxis_Line_Style[1] = yAxis_Line_Style2;
        yAxis_Line_Style[2] = yAxis_Line_Style3;
        yAxis_Line_Style[3] = yAxis_Line_Style4;
        return yAxis_Line_Style;
    }

    public float getYAxis_Line_Style1() {
        return yAxis_Line_Style1;
    }

    public float getYAxis_Line_Style2() {
        return yAxis_Line_Style2;
    }

    public float getYAxis_Line_Style3() {
        return yAxis_Line_Style3;
    }

    public float getYAxis_Line_Style4() {
        return yAxis_Line_Style4;
    }

    public boolean getYAxis_Grid_On() {
        return yAxis_Grid_On;
    }

    public Color getYAxis_Grid_Color() {
        return yAxis_Grid_Color;
    }

    public float getYAxis_Grid_Size() {
        return yAxis_Grid_Size;
    }

    public float getYAxis_Grid_Spacing() {
        return yAxis_Grid_Spacing;
    }

    public float[] getYAxis_Grid_Style() {
        float[] yAxis_Grid_Style = new float[4];
        yAxis_Grid_Style[0] = yAxis_Grid_Style1;
        yAxis_Grid_Style[1] = yAxis_Grid_Style2;
        yAxis_Grid_Style[2] = yAxis_Grid_Style3;
        yAxis_Grid_Style[3] = yAxis_Grid_Style4;
        return yAxis_Grid_Style;
    }

    public float getYAxis_Grid_Style1() {
        return yAxis_Grid_Style1;
    }

    public float getYAxis_Grid_Style2() {
        return yAxis_Grid_Style2;
    }

    public float getYAxis_Grid_Style3() {
        return yAxis_Grid_Style3;
    }

    public float getYAxis_Grid_Style4() {
        return yAxis_Grid_Style4;
    }

    public boolean getYAxis_TickMarks_On() {
        return yAxis_TickMarks_On;
    }

    public int getYAxis_TickMarks_Size() {
        return yAxis_TickMarks_Size;
    }

    public float getYAxis_TickMarks_Spacing() {
        return yAxis_TickMarks_Spacing;
    }

    public float getYAxis_TickMarks_Length() {
        return yAxis_TickMarks_Length;
    }

    public Color getYAxis_TickMarks_Color() {
        return yAxis_TickMarks_Color;
    }

    public boolean getYAxis_TickLabel_On() {
        return yAxis_TickLabel_On;
    }

    public String getYAxis_TickLabel_Font() {
        return yAxis_TickLabel_Font;
    }

    public int getYAxis_TickLabel_FontSize() {
        return yAxis_TickLabel_FontSize;
    }

    public Color getYAxis_TickLabel_Color() {
        return yAxis_TickLabel_Color;
    }

    public float getYAxis_TickLabel_xAlign() {
        return yAxis_TickLabel_xAlign;
    }

    public float getYAxis_TickLabel_yAlign() {
        return yAxis_TickLabel_yAlign;
    }

    public float getYAxis_TickLabel_Spacing() {
        return yAxis_TickLabel_Spacing;
    }

    public boolean getDialogOkSuccess() {
        return dialogOkSuccess;
    }

    protected void renderComboBox() {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = e.getAllFonts(); // Get the fonts
        for (Font f : fonts) {
            //System.out.println(f.getFontName());
            jComboBox_plot_Title_Font.addItem(f.getFontName());
            jComboBox_xAxis_Label_Font.addItem(f.getFontName());
            jComboBox_xAxis_TickLabel_Font.addItem(f.getFontName());
            jComboBox_yAxis_Label_Font.addItem(f.getFontName());
            jComboBox_yAxis_TickLabel_Font.addItem(f.getFontName());
        }
        ListCellRenderer lsr = new ListCellRenderer() {

            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                final JLabel renderer = new JLabel(value.toString());
                if (isSelected) {
                    renderer.setOpaque(false);
                    renderer.setForeground(Color.RED);
                    renderer.setBackground(Color.GREEN);
                }
                return renderer;
            }
        };
        jComboBox_plot_Title_Font.setRenderer(lsr);
        jComboBox_xAxis_Label_Font.setRenderer(lsr);
        jComboBox_xAxis_TickLabel_Font.setRenderer(lsr);
        jComboBox_yAxis_Label_Font.setRenderer(lsr);
        jComboBox_yAxis_TickLabel_Font.setRenderer(lsr);


        //        JComboBox.KeySelectionManager manager = new JComboBox.KeySelectionManager() {
//
//            public int selectionForKey(char aKey, ComboBoxModel aModel) {
//                System.out.println(aKey);
//                return -1;
//            }
//        };
//        jComboBox_plot_Title_Font.setKeySelectionManager(manager);


    }

    protected void setLAF() {
        //super(aThis);
        //this.setLocationRelativeTo(aThis);
        this.setLocationByPlatform(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(JDialog_Plot_Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(JDialog_Plot_Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(JDialog_Plot_Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JDialog_Plot_Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Heading = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel_Buttons = new javax.swing.JPanel();
        jButton_Ok = new javax.swing.JButton();
        jButton_Default = new javax.swing.JButton();
        jButton_Apply = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel_Plot = new javax.swing.JPanel();
        jPanel_plot_Title = new javax.swing.JPanel();
        jLabel_plot_Title_Text = new javax.swing.JLabel();
        jTextField_plot_Title_Text = new javax.swing.JTextField();
        jLabel_plot_Title_Font = new javax.swing.JLabel();
        jComboBox_plot_Title_Font = new javax.swing.JComboBox();
        jLabel_plot_Title_FontSize = new javax.swing.JLabel();
        jTextField_plot_Title_FontSize = new javax.swing.JTextField();
        jLabel_plot_Title_xAlign = new javax.swing.JLabel();
        jTextField_plot_Title_xAlign = new javax.swing.JTextField();
        jLabel_plot_Title_yAlign = new javax.swing.JLabel();
        jTextField_plot_Title_yAlign = new javax.swing.JTextField();
        jLabel_plot_Title_Color = new javax.swing.JLabel();
        jPanel_plot_Title_Color = new javax.swing.JPanel();
        jPanel_plot_Line = new javax.swing.JPanel();
        jLabel_plot_Line_Size = new javax.swing.JLabel();
        jTextField_plot_Line_Size = new javax.swing.JTextField();
        jLabel_plot_Line_Color = new javax.swing.JLabel();
        jPanel_plot_Line_Color = new javax.swing.JPanel();
        jLabel_plot_Line_Style = new javax.swing.JLabel();
        jTextField_plot_Line_Style1 = new javax.swing.JTextField();
        jTextField_plot_Line_Style2 = new javax.swing.JTextField();
        jTextField_plot_Line_Style3 = new javax.swing.JTextField();
        jTextField_plot_Line_Style4 = new javax.swing.JTextField();
        jLabel_plot_Background_Color = new javax.swing.JLabel();
        jPanel_plot_Background_Color = new javax.swing.JPanel();
        jLabel_plot_Line_Type = new javax.swing.JLabel();
        jComboBox_plot_Line_Type = new javax.swing.JComboBox();
        jPanel_plot_Marker = new javax.swing.JPanel();
        jLabel_plot_Marker_On = new javax.swing.JLabel();
        jCheckBox_plot_Marker_On = new javax.swing.JCheckBox();
        jLabel_plot_Marker_Size = new javax.swing.JLabel();
        jTextField_plot_Marker_Size = new javax.swing.JTextField();
        jLabel_plot_Marker_Type = new javax.swing.JLabel();
        jComboBox_plot_Marker_Type = new javax.swing.JComboBox();
        jLabel_plot_Marker_Color = new javax.swing.JLabel();
        jPanel_plot_Marker_Color = new javax.swing.JPanel();
        jLabel_plot_Marker_FillColor = new javax.swing.JLabel();
        jPanel_plot_Marker_FillColor = new javax.swing.JPanel();
        jLabel_plot_Marker_Style = new javax.swing.JLabel();
        jTextField_plot_Marker_Style1 = new javax.swing.JTextField();
        jTextField_plot_Marker_Style2 = new javax.swing.JTextField();
        jLabel_plot_Marker_Thickness = new javax.swing.JLabel();
        jTextField_plot_Marker_Thickness = new javax.swing.JTextField();
        jPanel_plot_Box = new javax.swing.JPanel();
        jLabel_plot_Box_On = new javax.swing.JLabel();
        jCheckBox_plot_Box_On = new javax.swing.JCheckBox();
        jLabel_plot_Box_Padding = new javax.swing.JLabel();
        jTextField_plot_Box_Padding1 = new javax.swing.JTextField();
        jLabel_plot_Box_Size = new javax.swing.JLabel();
        jTextField_plot_Box_Size = new javax.swing.JTextField();
        jLabel_plot_Box_Color = new javax.swing.JLabel();
        jLabel_plot_Box_FillColor = new javax.swing.JLabel();
        jPanel_plot_Box_Color = new javax.swing.JPanel();
        jPanel_plot_Box_FillColor = new javax.swing.JPanel();
        jLabel_plot_Box_Style = new javax.swing.JLabel();
        jTextField_plot_Box_Style1 = new javax.swing.JTextField();
        jTextField_plot_Box_Style2 = new javax.swing.JTextField();
        jTextField_plot_Box_Style3 = new javax.swing.JTextField();
        jTextField_plot_Box_Style4 = new javax.swing.JTextField();
        jTextField_plot_Box_Padding2 = new javax.swing.JTextField();
        jTextField_plot_Box_Padding3 = new javax.swing.JTextField();
        jTextField_plot_Box_Padding4 = new javax.swing.JTextField();
        jPanel_xAxis = new javax.swing.JPanel();
        jPanel_xAxis_Label = new javax.swing.JPanel();
        jLabel_xAxis_Label_Text = new javax.swing.JLabel();
        jTextField_xAxis_Label_Text = new javax.swing.JTextField();
        jLabel_xAxis_Label_Font = new javax.swing.JLabel();
        jComboBox_xAxis_Label_Font = new javax.swing.JComboBox();
        jLabel_xAxis_Label_Color = new javax.swing.JLabel();
        jPanel_xAxis_Label_Color = new javax.swing.JPanel();
        jLabel_xAxis_Label_FontSize = new javax.swing.JLabel();
        jTextField_xAxis_Label_FontSize = new javax.swing.JTextField();
        jLabel_xAxis_Label_xAlign = new javax.swing.JLabel();
        jTextField_xAxis_Label_xAlign = new javax.swing.JTextField();
        jLabel_xAxis_Label_yAlign = new javax.swing.JLabel();
        jTextField_xAxis_Label_yAlign = new javax.swing.JTextField();
        jPanel_xAxis_Axis = new javax.swing.JPanel();
        jLabel_xAxis_Auto = new javax.swing.JLabel();
        jCheckBox_xAxis_Auto = new javax.swing.JCheckBox();
        jLabel_xAxis_Min = new javax.swing.JLabel();
        jTextField_xAxis_Min = new javax.swing.JTextField();
        jLabel_xAxis_Max = new javax.swing.JLabel();
        jTextField_xAxis_Max = new javax.swing.JTextField();
        jPanel_xAxis_Line = new javax.swing.JPanel();
        jLabel_xAxis_Line_Size = new javax.swing.JLabel();
        jTextField_xAxis_Line_Size = new javax.swing.JTextField();
        jLabel_xAxis_Line_Color = new javax.swing.JLabel();
        jPanel_xAxis_Line_Color = new javax.swing.JPanel();
        jLabel_xAxis_Line_Style = new javax.swing.JLabel();
        jTextField_xAxis_Line_Style1 = new javax.swing.JTextField();
        jTextField_xAxis_Line_Style2 = new javax.swing.JTextField();
        jTextField_xAxis_Line_Style3 = new javax.swing.JTextField();
        jTextField_xAxis_Line_Style4 = new javax.swing.JTextField();
        jPanel_xAxis_Grid = new javax.swing.JPanel();
        jLabel_xAxis_Grid_On = new javax.swing.JLabel();
        jCheckBox_xAxis_Grid_On = new javax.swing.JCheckBox();
        jLabel_xAxis_Grid_Color = new javax.swing.JLabel();
        jPanel_xAxis_Grid_Color = new javax.swing.JPanel();
        jLabel_xAxis_Grid_Size = new javax.swing.JLabel();
        jTextField_xAxis_Grid_Size = new javax.swing.JTextField();
        jLabel_xAxis_Grid_Spacing = new javax.swing.JLabel();
        jTextField_xAxis_Grid_Spacing = new javax.swing.JTextField();
        jLabel_xAxis_Grid_Style = new javax.swing.JLabel();
        jTextField_xAxis_Grid_Style1 = new javax.swing.JTextField();
        jTextField_xAxis_Grid_Style2 = new javax.swing.JTextField();
        jTextField_xAxis_Grid_Style3 = new javax.swing.JTextField();
        jTextField_xAxis_Grid_Style4 = new javax.swing.JTextField();
        jPanel_xAxis_TickMarks = new javax.swing.JPanel();
        jLabel_xAxis_TickMarks_On = new javax.swing.JLabel();
        jCheckBox_xAxis_TickMarks_On = new javax.swing.JCheckBox();
        jLabel_xAxis_TickMarks_Size = new javax.swing.JLabel();
        jTextField_xAxis_TickMarks_Size = new javax.swing.JTextField();
        jLabel_xAxis_TickMarks_Spacing = new javax.swing.JLabel();
        jTextField_xAxis_TickMarks_Spacing = new javax.swing.JTextField();
        jLabel_xAxis_TickMarks_Color = new javax.swing.JLabel();
        jPanel_xAxis_TickMarks_Color = new javax.swing.JPanel();
        jTextField_xAxis_TickMarks_Length = new javax.swing.JTextField();
        jLabel_xAxis_TickMarks_Length = new javax.swing.JLabel();
        jPanel_xAxis_TickLabel = new javax.swing.JPanel();
        jLabel_xAxis_TickLabel_On = new javax.swing.JLabel();
        jCheckBox_xAxis_TickLabel_On = new javax.swing.JCheckBox();
        jLabel_xAxis_TickLabel_Font = new javax.swing.JLabel();
        jComboBox_xAxis_TickLabel_Font = new javax.swing.JComboBox();
        jLabel_xAxis_TickLabel_FontSize = new javax.swing.JLabel();
        jTextField_xAxis_TickLabel_FontSize = new javax.swing.JTextField();
        jLabel_xAxis_TickLabel_Color = new javax.swing.JLabel();
        jPanel_xAxis_TickLabel_Color = new javax.swing.JPanel();
        jLabel_xAxis_TickLabel_xAlign = new javax.swing.JLabel();
        jTextField_xAxis_TickLabel_xAlign = new javax.swing.JTextField();
        jLabel_xAxis_TickLabel_yAlign = new javax.swing.JLabel();
        jTextField_xAxis_TickLabel_yAlign = new javax.swing.JTextField();
        jTextField_xAxis_TickLabel_Spacing = new javax.swing.JTextField();
        jLabel_xAxis_TickLabel_Spacing = new javax.swing.JLabel();
        jPanel_yAxis1 = new javax.swing.JPanel();
        jPanel_yAxis_Label = new javax.swing.JPanel();
        jLabel_yAxis_Label_Text = new javax.swing.JLabel();
        jTextField_yAxis_Label_Text = new javax.swing.JTextField();
        jLabel_yAxis_Label_Font = new javax.swing.JLabel();
        jComboBox_yAxis_Label_Font = new javax.swing.JComboBox();
        jLabel_yAxis_Label_Color = new javax.swing.JLabel();
        jPanel_yAxis_Label_Color = new javax.swing.JPanel();
        jLabel_yAxis_Label_FontSize = new javax.swing.JLabel();
        jTextField_yAxis_Label_FontSize = new javax.swing.JTextField();
        jLabel_yAxis_Label_xAlign = new javax.swing.JLabel();
        jTextField_yAxis_Label_xAlign = new javax.swing.JTextField();
        jLabel_yAxis_Label_yAlign = new javax.swing.JLabel();
        jTextField_yAxis_Label_yAlign = new javax.swing.JTextField();
        jPanel_yAxis_Axis = new javax.swing.JPanel();
        jLabel_yAxis_Auto = new javax.swing.JLabel();
        jCheckBox_yAxis_Auto = new javax.swing.JCheckBox();
        jLabel_yAxis_Min = new javax.swing.JLabel();
        jTextField_yAxis_Min = new javax.swing.JTextField();
        jLabel_yAxis_Max = new javax.swing.JLabel();
        jTextField_yAxis_Max = new javax.swing.JTextField();
        jPanel_yAxis_Line = new javax.swing.JPanel();
        jLabel_yAxis_Line_Size = new javax.swing.JLabel();
        jTextField_yAxis_Line_Size = new javax.swing.JTextField();
        jLabel_yAxis_Line_Color = new javax.swing.JLabel();
        jPanel_yAxis_Line_Color = new javax.swing.JPanel();
        jLabel_yAxis_Line_Style = new javax.swing.JLabel();
        jTextField_yAxis_Line_Style1 = new javax.swing.JTextField();
        jTextField_yAxis_Line_Style2 = new javax.swing.JTextField();
        jTextField_yAxis_Line_Style3 = new javax.swing.JTextField();
        jTextField_yAxis_Line_Style4 = new javax.swing.JTextField();
        jPanel_yAxis_Grid = new javax.swing.JPanel();
        jLabel_yAxis_Grid_On = new javax.swing.JLabel();
        jCheckBox_yAxis_Grid_On = new javax.swing.JCheckBox();
        jLabel_yAxis_Grid_Color = new javax.swing.JLabel();
        jPanel_yAxis_Grid_Color = new javax.swing.JPanel();
        jLabel_yAxis_Grid_Size = new javax.swing.JLabel();
        jTextField_yAxis_Grid_Size = new javax.swing.JTextField();
        jLabel__yAxis_Grid_Spacing = new javax.swing.JLabel();
        jTextField_yAxis_Grid_Spacing = new javax.swing.JTextField();
        jLabel_yAxis_Grid_Style = new javax.swing.JLabel();
        jTextField_yAxis_Grid_Style1 = new javax.swing.JTextField();
        jTextField_yAxis_Grid_Style2 = new javax.swing.JTextField();
        jTextField_yAxis_Grid_Style3 = new javax.swing.JTextField();
        jTextField_yAxis_Grid_Style4 = new javax.swing.JTextField();
        jPanel_yAxis_TickMarks = new javax.swing.JPanel();
        jLabel_yAxis_TickMarks_On = new javax.swing.JLabel();
        jCheckBox_yAxis_TickMarks_On = new javax.swing.JCheckBox();
        jLabel_yAxis_TickMarks_Size = new javax.swing.JLabel();
        jTextField_yAxis_TickMarks_Size = new javax.swing.JTextField();
        jLabel_yAxis_TickMarks_Spacing = new javax.swing.JLabel();
        jTextField_yAxis_TickMarks_Spacing = new javax.swing.JTextField();
        jLabel_yAxis_TickMarks_Color = new javax.swing.JLabel();
        jPanel_yAxis_TickMarks_Color = new javax.swing.JPanel();
        jTextField_yAxis_TickMarks_Length = new javax.swing.JTextField();
        jLabel_yAxis_TickMarks_Length = new javax.swing.JLabel();
        jPanel_yAxis_TickLabel = new javax.swing.JPanel();
        jLabel_yAxis_TickLabel_On = new javax.swing.JLabel();
        jCheckBox_yAxis_TickLabel_On = new javax.swing.JCheckBox();
        jLabel_yAxis_TickLabel_Font = new javax.swing.JLabel();
        jComboBox_yAxis_TickLabel_Font = new javax.swing.JComboBox();
        jLabel_yAxis_TickLabel_FontSize = new javax.swing.JLabel();
        jTextField_yAxis_TickLabel_FontSize = new javax.swing.JTextField();
        jLabel_yAxis_TickLabel_Color = new javax.swing.JLabel();
        jPanel_yAxis_TickLabel_Color = new javax.swing.JPanel();
        jLabel_yAxis_TickLabel_xAlign = new javax.swing.JLabel();
        jTextField_yAxis_TickLabel_xAlign = new javax.swing.JTextField();
        jLabel_yAxis_TickLabel_yAlign = new javax.swing.JLabel();
        jTextField_yAxis_TickLabel_yAlign = new javax.swing.JTextField();
        jTextField_yAxis_TickLabel_Spacing = new javax.swing.JTextField();
        jLabel_yAxis_TickLabel_Spacing = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel_Heading.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Plot Settings");

        javax.swing.GroupLayout jPanel_HeadingLayout = new javax.swing.GroupLayout(jPanel_Heading);
        jPanel_Heading.setLayout(jPanel_HeadingLayout);
        jPanel_HeadingLayout.setHorizontalGroup(
            jPanel_HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_HeadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(426, Short.MAX_VALUE))
        );
        jPanel_HeadingLayout.setVerticalGroup(
            jPanel_HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_HeadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_Ok.setText("Ok");
        jButton_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OkActionPerformed(evt);
            }
        });

        jButton_Default.setText("Default");
        jButton_Default.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DefaultActionPerformed(evt);
            }
        });

        jButton_Apply.setText("Apply");
        jButton_Apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ApplyActionPerformed(evt);
            }
        });

        jButton_Cancel.setText("Cancel");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ButtonsLayout = new javax.swing.GroupLayout(jPanel_Buttons);
        jPanel_Buttons.setLayout(jPanel_ButtonsLayout);
        jPanel_ButtonsLayout.setHorizontalGroup(
            jPanel_ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ButtonsLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jButton_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Apply, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Default)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Cancel)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel_ButtonsLayout.setVerticalGroup(
            jPanel_ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ButtonsLayout.createSequentialGroup()
                .addGroup(jPanel_ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton_Ok)
                    .addComponent(jButton_Apply)
                    .addComponent(jButton_Default)
                    .addComponent(jButton_Cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.setPreferredSize(new java.awt.Dimension(570, 420));

        jPanel_plot_Title.setBorder(javax.swing.BorderFactory.createTitledBorder("Title"));

        jLabel_plot_Title_Text.setText("Text:");

        jLabel_plot_Title_Font.setText("Font:");

        jComboBox_plot_Title_Font.setEditable(true);
        jComboBox_plot_Title_Font.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arial", "Tahoma", "Serif", "Times" }));

        jLabel_plot_Title_FontSize.setText("Font Size:");

        jTextField_plot_Title_FontSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Title_FontSize.setToolTipText("Set Integer");
        jTextField_plot_Title_FontSize.setInputVerifier(verifyInt);
        jTextField_plot_Title_FontSize.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel_plot_Title_xAlign.setText("xAlign:");

        jTextField_plot_Title_xAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Title_xAlign.setToolTipText("Set Real Number");
        jTextField_plot_Title_xAlign.setInputVerifier(verifyFloat);

        jLabel_plot_Title_yAlign.setText("yAlign:");

        jTextField_plot_Title_yAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Title_yAlign.setToolTipText("Set Real Number");
        jTextField_plot_Title_yAlign.setInputVerifier(verifyFloat);
        jTextField_plot_Title_yAlign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_plot_Title_yAlignActionPerformed(evt);
            }
        });

        jLabel_plot_Title_Color.setText("Color:");

        jPanel_plot_Title_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_plot_Title_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_plot_Title_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_plot_Title_ColorLayout = new javax.swing.GroupLayout(jPanel_plot_Title_Color);
        jPanel_plot_Title_Color.setLayout(jPanel_plot_Title_ColorLayout);
        jPanel_plot_Title_ColorLayout.setHorizontalGroup(
            jPanel_plot_Title_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_plot_Title_ColorLayout.setVerticalGroup(
            jPanel_plot_Title_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel_plot_TitleLayout = new javax.swing.GroupLayout(jPanel_plot_Title);
        jPanel_plot_Title.setLayout(jPanel_plot_TitleLayout);
        jPanel_plot_TitleLayout.setHorizontalGroup(
            jPanel_plot_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_plot_TitleLayout.createSequentialGroup()
                .addGroup(jPanel_plot_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_plot_TitleLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel_plot_Title_Text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_plot_Title_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_plot_TitleLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel_plot_Title_Font)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_plot_Title_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_plot_Title_Color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_plot_Title_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_plot_TitleLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel_plot_Title_FontSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_plot_Title_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_plot_Title_xAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_plot_Title_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_plot_Title_yAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_plot_Title_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_plot_TitleLayout.setVerticalGroup(
            jPanel_plot_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_plot_TitleLayout.createSequentialGroup()
                .addGroup(jPanel_plot_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Title_Text)
                    .addComponent(jTextField_plot_Title_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_plot_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Title_Font)
                    .addComponent(jComboBox_plot_Title_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Title_Color)
                    .addComponent(jPanel_plot_Title_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_plot_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Title_FontSize)
                    .addComponent(jTextField_plot_Title_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Title_xAlign)
                    .addComponent(jTextField_plot_Title_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Title_yAlign)
                    .addComponent(jTextField_plot_Title_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_plot_Line.setBorder(javax.swing.BorderFactory.createTitledBorder("Line"));

        jLabel_plot_Line_Size.setText("Size:");

        jTextField_plot_Line_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Line_Size.setToolTipText("Set Real Number");
        jTextField_plot_Line_Size.setInputVerifier(verifyFloat);

        jLabel_plot_Line_Color.setText("Color:");

        jPanel_plot_Line_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_plot_Line_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_plot_Line_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_plot_Line_ColorLayout = new javax.swing.GroupLayout(jPanel_plot_Line_Color);
        jPanel_plot_Line_Color.setLayout(jPanel_plot_Line_ColorLayout);
        jPanel_plot_Line_ColorLayout.setHorizontalGroup(
            jPanel_plot_Line_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_plot_Line_ColorLayout.setVerticalGroup(
            jPanel_plot_Line_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_plot_Line_Style.setText("Style:");

        jTextField_plot_Line_Style1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Line_Style1.setToolTipText("Set Real Number");
        jTextField_plot_Line_Style1.setInputVerifier(verifyFloat);
        jTextField_plot_Line_Style1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_plot_Line_Style1ActionPerformed(evt);
            }
        });

        jTextField_plot_Line_Style2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Line_Style2.setToolTipText("Set Real Number");
        jTextField_plot_Line_Style2.setInputVerifier(verifyFloat);

        jTextField_plot_Line_Style3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Line_Style3.setToolTipText("Set Real Number");
        jTextField_plot_Line_Style3.setInputVerifier(verifyFloat);

        jTextField_plot_Line_Style4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Line_Style4.setToolTipText("Set Real Number");
        jTextField_plot_Line_Style4.setInputVerifier(verifyFloat);

        jLabel_plot_Background_Color.setText("Background:");

        jPanel_plot_Background_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_plot_Background_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_plot_Background_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_plot_Background_ColorLayout = new javax.swing.GroupLayout(jPanel_plot_Background_Color);
        jPanel_plot_Background_Color.setLayout(jPanel_plot_Background_ColorLayout);
        jPanel_plot_Background_ColorLayout.setHorizontalGroup(
            jPanel_plot_Background_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_plot_Background_ColorLayout.setVerticalGroup(
            jPanel_plot_Background_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_plot_Line_Type.setText("Type:");

        jComboBox_plot_Line_Type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Line", "Stair" }));

        javax.swing.GroupLayout jPanel_plot_LineLayout = new javax.swing.GroupLayout(jPanel_plot_Line);
        jPanel_plot_Line.setLayout(jPanel_plot_LineLayout);
        jPanel_plot_LineLayout.setHorizontalGroup(
            jPanel_plot_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_plot_LineLayout.createSequentialGroup()
                .addGroup(jPanel_plot_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_plot_LineLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel_plot_Line_Size)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_plot_Line_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_plot_Line_Type)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_plot_Line_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_plot_LineLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_plot_Line_Color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_plot_Line_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_plot_Background_Color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_plot_Background_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_plot_LineLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_plot_Line_Style)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_plot_Line_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_plot_Line_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_plot_Line_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_plot_Line_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_plot_LineLayout.setVerticalGroup(
            jPanel_plot_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_plot_LineLayout.createSequentialGroup()
                .addGroup(jPanel_plot_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Line_Size)
                    .addComponent(jTextField_plot_Line_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Line_Type)
                    .addComponent(jComboBox_plot_Line_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_plot_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Line_Color)
                    .addComponent(jPanel_plot_Line_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Background_Color)
                    .addComponent(jPanel_plot_Background_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_plot_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Line_Style)
                    .addComponent(jTextField_plot_Line_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Line_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Line_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Line_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel_plot_Marker.setBorder(javax.swing.BorderFactory.createTitledBorder("Marker"));

        jLabel_plot_Marker_On.setText("On:");

        jCheckBox_plot_Marker_On.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_plot_Marker_OnActionPerformed(evt);
            }
        });

        jLabel_plot_Marker_Size.setText("Size:");

        jTextField_plot_Marker_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Marker_Size.setToolTipText("Set Real Number");
        jTextField_plot_Marker_Size.setInputVerifier(verifyFloat);

        jLabel_plot_Marker_Type.setText("Type:");

        jComboBox_plot_Marker_Type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Circle", "Square" }));

        jLabel_plot_Marker_Color.setText("Color:");

        jPanel_plot_Marker_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_plot_Marker_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_plot_Marker_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_plot_Marker_ColorLayout = new javax.swing.GroupLayout(jPanel_plot_Marker_Color);
        jPanel_plot_Marker_Color.setLayout(jPanel_plot_Marker_ColorLayout);
        jPanel_plot_Marker_ColorLayout.setHorizontalGroup(
            jPanel_plot_Marker_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_plot_Marker_ColorLayout.setVerticalGroup(
            jPanel_plot_Marker_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_plot_Marker_FillColor.setText("Fill Color:");

        jPanel_plot_Marker_FillColor.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_plot_Marker_FillColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_plot_Marker_FillColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_plot_Marker_FillColorLayout = new javax.swing.GroupLayout(jPanel_plot_Marker_FillColor);
        jPanel_plot_Marker_FillColor.setLayout(jPanel_plot_Marker_FillColorLayout);
        jPanel_plot_Marker_FillColorLayout.setHorizontalGroup(
            jPanel_plot_Marker_FillColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_plot_Marker_FillColorLayout.setVerticalGroup(
            jPanel_plot_Marker_FillColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_plot_Marker_Style.setText("Style:");

        jTextField_plot_Marker_Style1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Marker_Style1.setToolTipText("Set Real Number");
        jTextField_plot_Marker_Style1.setInputVerifier(verifyFloat);
        jTextField_plot_Marker_Style1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_plot_Marker_Style1ActionPerformed(evt);
            }
        });

        jTextField_plot_Marker_Style2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Marker_Style2.setToolTipText("Set Real Number");
        jTextField_plot_Marker_Style2.setInputVerifier(verifyFloat);

        jLabel_plot_Marker_Thickness.setText("Weight:");

        jTextField_plot_Marker_Thickness.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Marker_Thickness.setToolTipText("Set Real Number");
        jTextField_plot_Marker_Thickness.setInputVerifier(verifyFloat);

        javax.swing.GroupLayout jPanel_plot_MarkerLayout = new javax.swing.GroupLayout(jPanel_plot_Marker);
        jPanel_plot_Marker.setLayout(jPanel_plot_MarkerLayout);
        jPanel_plot_MarkerLayout.setHorizontalGroup(
            jPanel_plot_MarkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_plot_MarkerLayout.createSequentialGroup()
                .addGroup(jPanel_plot_MarkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_plot_MarkerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_plot_Marker_On)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox_plot_Marker_On)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_plot_Marker_Size)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_plot_Marker_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_plot_Marker_Type)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_plot_Marker_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_plot_MarkerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_plot_MarkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_plot_Marker_Style)
                            .addGroup(jPanel_plot_MarkerLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jTextField_plot_Marker_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_plot_Marker_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_plot_Marker_Color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_plot_Marker_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_plot_MarkerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_plot_Marker_Thickness)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_plot_Marker_Thickness, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_plot_Marker_FillColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_plot_Marker_FillColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_plot_MarkerLayout.setVerticalGroup(
            jPanel_plot_MarkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_plot_MarkerLayout.createSequentialGroup()
                .addGroup(jPanel_plot_MarkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Marker_On)
                    .addComponent(jCheckBox_plot_Marker_On)
                    .addComponent(jLabel_plot_Marker_Size)
                    .addComponent(jTextField_plot_Marker_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Marker_Type)
                    .addComponent(jComboBox_plot_Marker_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_plot_MarkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Marker_Style)
                    .addComponent(jTextField_plot_Marker_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Marker_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Marker_Color)
                    .addComponent(jPanel_plot_Marker_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_plot_MarkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Marker_Thickness)
                    .addComponent(jTextField_plot_Marker_Thickness, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Marker_FillColor)
                    .addComponent(jPanel_plot_Marker_FillColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_plot_Box.setBorder(javax.swing.BorderFactory.createTitledBorder("Box"));

        jLabel_plot_Box_On.setText("On:");

        jCheckBox_plot_Box_On.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_plot_Box_OnActionPerformed(evt);
            }
        });

        jLabel_plot_Box_Padding.setText("Padding:");

        jTextField_plot_Box_Padding1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Box_Padding1.setToolTipText("Set Integer Number for West Padding");
        jTextField_plot_Box_Padding1.setInputVerifier(verifyFloat);

        jLabel_plot_Box_Size.setText("Size:");

        jTextField_plot_Box_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Box_Size.setToolTipText("Set Real Number");
        jTextField_plot_Box_Size.setInputVerifier(verifyFloat);

        jLabel_plot_Box_Color.setText("Color:");

        jLabel_plot_Box_FillColor.setText("Fill Color:");

        jPanel_plot_Box_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_plot_Box_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_plot_Box_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_plot_Box_ColorLayout = new javax.swing.GroupLayout(jPanel_plot_Box_Color);
        jPanel_plot_Box_Color.setLayout(jPanel_plot_Box_ColorLayout);
        jPanel_plot_Box_ColorLayout.setHorizontalGroup(
            jPanel_plot_Box_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_plot_Box_ColorLayout.setVerticalGroup(
            jPanel_plot_Box_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel_plot_Box_FillColor.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_plot_Box_FillColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_plot_Box_FillColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_plot_Box_FillColorLayout = new javax.swing.GroupLayout(jPanel_plot_Box_FillColor);
        jPanel_plot_Box_FillColor.setLayout(jPanel_plot_Box_FillColorLayout);
        jPanel_plot_Box_FillColorLayout.setHorizontalGroup(
            jPanel_plot_Box_FillColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_plot_Box_FillColorLayout.setVerticalGroup(
            jPanel_plot_Box_FillColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_plot_Box_Style.setText("Style:");

        jTextField_plot_Box_Style1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Box_Style1.setToolTipText("Set Real Number");
        jTextField_plot_Box_Style1.setInputVerifier(verifyFloat);
        jTextField_plot_Box_Style1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_plot_Box_Style1ActionPerformed(evt);
            }
        });

        jTextField_plot_Box_Style2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Box_Style2.setToolTipText("Set Real Number");
        jTextField_plot_Box_Style2.setInputVerifier(verifyFloat);

        jTextField_plot_Box_Style3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Box_Style3.setToolTipText("Set Real Number");
        jTextField_plot_Box_Style3.setInputVerifier(verifyFloat);

        jTextField_plot_Box_Style4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Box_Style4.setToolTipText("Set Real Number");
        jTextField_plot_Box_Style4.setInputVerifier(verifyFloat);
        jTextField_plot_Box_Style4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_plot_Box_Style4ActionPerformed(evt);
            }
        });

        jTextField_plot_Box_Padding2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Box_Padding2.setToolTipText("Set Integer Number for North Padding");
        jTextField_plot_Box_Padding2.setInputVerifier(verifyFloat);

        jTextField_plot_Box_Padding3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Box_Padding3.setToolTipText("Set Integer Number for East Padding");
        jTextField_plot_Box_Padding3.setInputVerifier(verifyFloat);

        jTextField_plot_Box_Padding4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_plot_Box_Padding4.setToolTipText("Set Integer Number for South Padding");
        jTextField_plot_Box_Padding4.setInputVerifier(verifyFloat);

        javax.swing.GroupLayout jPanel_plot_BoxLayout = new javax.swing.GroupLayout(jPanel_plot_Box);
        jPanel_plot_Box.setLayout(jPanel_plot_BoxLayout);
        jPanel_plot_BoxLayout.setHorizontalGroup(
            jPanel_plot_BoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_plot_BoxLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_plot_BoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_plot_Box_Style, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_plot_Box_On, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_plot_BoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_plot_BoxLayout.createSequentialGroup()
                        .addComponent(jTextField_plot_Box_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_plot_Box_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_plot_Box_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_plot_Box_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_plot_Box_Padding)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_plot_Box_Padding1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField_plot_Box_Padding2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField_plot_Box_Padding3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_plot_Box_Padding4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_plot_BoxLayout.createSequentialGroup()
                        .addComponent(jCheckBox_plot_Box_On)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_plot_BoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_plot_BoxLayout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jLabel_plot_Box_Size)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_plot_Box_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_plot_BoxLayout.createSequentialGroup()
                                .addComponent(jLabel_plot_Box_Color)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_plot_Box_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_plot_Box_FillColor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_plot_Box_FillColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel_plot_BoxLayout.setVerticalGroup(
            jPanel_plot_BoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_plot_BoxLayout.createSequentialGroup()
                .addGroup(jPanel_plot_BoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Box_On)
                    .addComponent(jCheckBox_plot_Box_On)
                    .addComponent(jLabel_plot_Box_Color)
                    .addComponent(jPanel_plot_Box_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Box_FillColor)
                    .addComponent(jPanel_plot_Box_FillColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Box_Size)
                    .addComponent(jTextField_plot_Box_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_plot_BoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_plot_Box_Style)
                    .addComponent(jTextField_plot_Box_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Box_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Box_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Box_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_plot_Box_Padding)
                    .addComponent(jTextField_plot_Box_Padding1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Box_Padding2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Box_Padding3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_plot_Box_Padding4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_PlotLayout = new javax.swing.GroupLayout(jPanel_Plot);
        jPanel_Plot.setLayout(jPanel_PlotLayout);
        jPanel_PlotLayout.setHorizontalGroup(
            jPanel_PlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PlotLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_PlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_plot_Box, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_PlotLayout.createSequentialGroup()
                        .addComponent(jPanel_plot_Line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_plot_Marker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel_plot_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel_PlotLayout.setVerticalGroup(
            jPanel_PlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PlotLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_plot_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_plot_Line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_plot_Marker, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_plot_Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane.addTab("Plot", jPanel_Plot);

        jPanel_xAxis_Label.setBorder(javax.swing.BorderFactory.createTitledBorder("Label"));

        jLabel_xAxis_Label_Text.setText("Text:");

        jLabel_xAxis_Label_Font.setText("Font:");

        jComboBox_xAxis_Label_Font.setEditable(true);
        jComboBox_xAxis_Label_Font.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arial", "Tahoma", "Serif", "Times" }));

        jLabel_xAxis_Label_Color.setText("Color:");

        jPanel_xAxis_Label_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_xAxis_Label_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_xAxis_Label_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_xAxis_Label_ColorLayout = new javax.swing.GroupLayout(jPanel_xAxis_Label_Color);
        jPanel_xAxis_Label_Color.setLayout(jPanel_xAxis_Label_ColorLayout);
        jPanel_xAxis_Label_ColorLayout.setHorizontalGroup(
            jPanel_xAxis_Label_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_xAxis_Label_ColorLayout.setVerticalGroup(
            jPanel_xAxis_Label_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_xAxis_Label_FontSize.setText("Size:");

        jTextField_xAxis_Label_FontSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Label_FontSize.setToolTipText("Set Integer");
        jTextField_xAxis_Label_FontSize.setInputVerifier(verifyInt);
        jTextField_xAxis_Label_FontSize.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel_xAxis_Label_xAlign.setText("xAlign:");

        jTextField_xAxis_Label_xAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Label_xAlign.setToolTipText("Set Integer");
        jTextField_xAxis_Label_xAlign.setInputVerifier(verifyFloat);

        jLabel_xAxis_Label_yAlign.setText("yAlign:");

        jTextField_xAxis_Label_yAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Label_yAlign.setToolTipText("Set Integer");
        jTextField_xAxis_Label_yAlign.setInputVerifier(verifyFloat);
        jTextField_xAxis_Label_yAlign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_xAxis_Label_yAlignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_xAxis_LabelLayout = new javax.swing.GroupLayout(jPanel_xAxis_Label);
        jPanel_xAxis_Label.setLayout(jPanel_xAxis_LabelLayout);
        jPanel_xAxis_LabelLayout.setHorizontalGroup(
            jPanel_xAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_LabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_xAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_xAxis_Label_Font, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_xAxis_Label_Text, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_xAxis_Label_FontSize, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_xAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_xAxis_Label_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_xAxis_LabelLayout.createSequentialGroup()
                        .addComponent(jComboBox_xAxis_Label_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_xAxis_Label_Color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_xAxis_Label_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_xAxis_LabelLayout.createSequentialGroup()
                        .addComponent(jTextField_xAxis_Label_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_xAxis_Label_xAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_xAxis_Label_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_xAxis_Label_yAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_xAxis_Label_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_xAxis_LabelLayout.setVerticalGroup(
            jPanel_xAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_LabelLayout.createSequentialGroup()
                .addGroup(jPanel_xAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_Label_Text)
                    .addComponent(jTextField_xAxis_Label_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel_xAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_Label_Font)
                    .addComponent(jComboBox_xAxis_Label_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_xAxis_Label_Color)
                    .addComponent(jPanel_xAxis_Label_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_xAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_Label_FontSize)
                    .addComponent(jTextField_xAxis_Label_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_xAxis_Label_xAlign)
                    .addComponent(jTextField_xAxis_Label_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_xAxis_Label_yAlign)
                    .addComponent(jTextField_xAxis_Label_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_xAxis_Axis.setBorder(javax.swing.BorderFactory.createTitledBorder("Axis"));

        jLabel_xAxis_Auto.setText("Auto:");

        jCheckBox_xAxis_Auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_xAxis_AutoActionPerformed(evt);
            }
        });

        jLabel_xAxis_Min.setText("Min:");

        jTextField_xAxis_Min.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Min.setToolTipText("Set Real Number");
        jTextField_xAxis_Min.setInputVerifier(verifyFloat);
        jTextField_xAxis_Min.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel_xAxis_Max.setText("Max:");

        jTextField_xAxis_Max.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Max.setToolTipText("Set Real Number");
        jTextField_xAxis_Max.setInputVerifier(verifyFloat);
        jTextField_xAxis_Max.setPreferredSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout jPanel_xAxis_AxisLayout = new javax.swing.GroupLayout(jPanel_xAxis_Axis);
        jPanel_xAxis_Axis.setLayout(jPanel_xAxis_AxisLayout);
        jPanel_xAxis_AxisLayout.setHorizontalGroup(
            jPanel_xAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_AxisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_xAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_xAxis_Min, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_xAxis_Auto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_xAxis_Max, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_xAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_xAxis_Auto)
                    .addComponent(jTextField_xAxis_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_xAxis_Max, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_xAxis_AxisLayout.setVerticalGroup(
            jPanel_xAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_AxisLayout.createSequentialGroup()
                .addGroup(jPanel_xAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_xAxis_Auto)
                    .addComponent(jCheckBox_xAxis_Auto))
                .addGap(11, 11, 11)
                .addGroup(jPanel_xAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_xAxis_Min)
                    .addComponent(jTextField_xAxis_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_xAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_xAxis_Max)
                    .addComponent(jTextField_xAxis_Max, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_xAxis_Line.setBorder(javax.swing.BorderFactory.createTitledBorder("Line"));

        jLabel_xAxis_Line_Size.setText("Size:");

        jTextField_xAxis_Line_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Line_Size.setToolTipText("Set Real Number");
        jTextField_xAxis_Line_Size.setInputVerifier(verifyFloat);

        jLabel_xAxis_Line_Color.setText("Color:");

        jPanel_xAxis_Line_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_xAxis_Line_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_xAxis_Line_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_xAxis_Line_ColorLayout = new javax.swing.GroupLayout(jPanel_xAxis_Line_Color);
        jPanel_xAxis_Line_Color.setLayout(jPanel_xAxis_Line_ColorLayout);
        jPanel_xAxis_Line_ColorLayout.setHorizontalGroup(
            jPanel_xAxis_Line_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_xAxis_Line_ColorLayout.setVerticalGroup(
            jPanel_xAxis_Line_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_xAxis_Line_Style.setText("Style:");

        jTextField_xAxis_Line_Style1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Line_Style1.setToolTipText("Set Real Number");
        jTextField_xAxis_Line_Style1.setInputVerifier(verifyFloat);

        jTextField_xAxis_Line_Style2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Line_Style2.setToolTipText("Set Real Number");
        jTextField_xAxis_Line_Style2.setInputVerifier(verifyFloat);

        jTextField_xAxis_Line_Style3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Line_Style3.setToolTipText("Set Real Number");
        jTextField_xAxis_Line_Style3.setInputVerifier(verifyFloat);

        jTextField_xAxis_Line_Style4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Line_Style4.setToolTipText("Set Real Number");
        jTextField_xAxis_Line_Style4.setInputVerifier(verifyFloat);

        javax.swing.GroupLayout jPanel_xAxis_LineLayout = new javax.swing.GroupLayout(jPanel_xAxis_Line);
        jPanel_xAxis_Line.setLayout(jPanel_xAxis_LineLayout);
        jPanel_xAxis_LineLayout.setHorizontalGroup(
            jPanel_xAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_LineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_xAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_xAxis_LineLayout.createSequentialGroup()
                        .addGroup(jPanel_xAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_xAxis_Line_Color, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_xAxis_Line_Size, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_xAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel_xAxis_Line_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_xAxis_Line_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_xAxis_LineLayout.createSequentialGroup()
                        .addComponent(jLabel_xAxis_Line_Style)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_xAxis_Line_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_xAxis_Line_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_xAxis_Line_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_xAxis_Line_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_xAxis_LineLayout.setVerticalGroup(
            jPanel_xAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_LineLayout.createSequentialGroup()
                .addGroup(jPanel_xAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_Line_Color)
                    .addComponent(jPanel_xAxis_Line_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_xAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_Line_Size)
                    .addComponent(jTextField_xAxis_Line_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_xAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_Line_Style)
                    .addComponent(jTextField_xAxis_Line_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_xAxis_Line_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_xAxis_Line_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_xAxis_Line_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_xAxis_Grid.setBorder(javax.swing.BorderFactory.createTitledBorder("Grid"));
        jPanel_xAxis_Grid.setInputVerifier(verifyFloat);

        jLabel_xAxis_Grid_On.setText("On:");

        jCheckBox_xAxis_Grid_On.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_xAxis_Grid_OnActionPerformed(evt);
            }
        });

        jLabel_xAxis_Grid_Color.setText("Color:");

        jPanel_xAxis_Grid_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_xAxis_Grid_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_xAxis_Grid_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_xAxis_Grid_ColorLayout = new javax.swing.GroupLayout(jPanel_xAxis_Grid_Color);
        jPanel_xAxis_Grid_Color.setLayout(jPanel_xAxis_Grid_ColorLayout);
        jPanel_xAxis_Grid_ColorLayout.setHorizontalGroup(
            jPanel_xAxis_Grid_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_xAxis_Grid_ColorLayout.setVerticalGroup(
            jPanel_xAxis_Grid_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_xAxis_Grid_Size.setText("Size:");

        jTextField_xAxis_Grid_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Grid_Size.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Size.setInputVerifier(verifyFloat);

        jLabel_xAxis_Grid_Spacing.setText("Spacing:");

        jTextField_xAxis_Grid_Spacing.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Grid_Spacing.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Spacing.setInputVerifier(verifyFloat);
        jTextField_xAxis_Grid_Spacing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_xAxis_Grid_SpacingActionPerformed(evt);
            }
        });

        jLabel_xAxis_Grid_Style.setText("Style:");

        jTextField_xAxis_Grid_Style1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Grid_Style1.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Style1.setInputVerifier(verifyFloat);

        jTextField_xAxis_Grid_Style2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Grid_Style2.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Style2.setInputVerifier(verifyFloat);

        jTextField_xAxis_Grid_Style3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Grid_Style3.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Style3.setInputVerifier(verifyFloat);

        jTextField_xAxis_Grid_Style4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_Grid_Style4.setToolTipText("Set Real Number");
        jTextField_xAxis_Grid_Style4.setInputVerifier(verifyFloat);

        javax.swing.GroupLayout jPanel_xAxis_GridLayout = new javax.swing.GroupLayout(jPanel_xAxis_Grid);
        jPanel_xAxis_Grid.setLayout(jPanel_xAxis_GridLayout);
        jPanel_xAxis_GridLayout.setHorizontalGroup(
            jPanel_xAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_GridLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_xAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_xAxis_Grid_On, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_xAxis_Grid_Size, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_xAxis_Grid_Style, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_xAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_xAxis_GridLayout.createSequentialGroup()
                        .addComponent(jCheckBox_xAxis_Grid_On)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_xAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_xAxis_GridLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jPanel_xAxis_Grid_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel_xAxis_Grid_Color)))
                    .addGroup(jPanel_xAxis_GridLayout.createSequentialGroup()
                        .addComponent(jTextField_xAxis_Grid_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_xAxis_Grid_Spacing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_xAxis_Grid_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_xAxis_GridLayout.createSequentialGroup()
                        .addComponent(jTextField_xAxis_Grid_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_xAxis_Grid_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_xAxis_Grid_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_xAxis_Grid_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel_xAxis_GridLayout.setVerticalGroup(
            jPanel_xAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_GridLayout.createSequentialGroup()
                .addGroup(jPanel_xAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_Grid_On)
                    .addComponent(jCheckBox_xAxis_Grid_On)
                    .addComponent(jLabel_xAxis_Grid_Color)
                    .addComponent(jPanel_xAxis_Grid_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_xAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_Grid_Size)
                    .addComponent(jTextField_xAxis_Grid_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_xAxis_Grid_Spacing)
                    .addComponent(jTextField_xAxis_Grid_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_xAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_Grid_Style)
                    .addComponent(jTextField_xAxis_Grid_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_xAxis_Grid_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_xAxis_Grid_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_xAxis_Grid_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_xAxis_TickMarks.setBorder(javax.swing.BorderFactory.createTitledBorder("Tick Marks"));

        jLabel_xAxis_TickMarks_On.setText("On:");

        jCheckBox_xAxis_TickMarks_On.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_xAxis_TickMarks_OnActionPerformed(evt);
            }
        });

        jLabel_xAxis_TickMarks_Size.setText("Size:");

        jTextField_xAxis_TickMarks_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_TickMarks_Size.setToolTipText("Set Real Number");
        jTextField_xAxis_TickMarks_Size.setInputVerifier(verifyFloat);

        jLabel_xAxis_TickMarks_Spacing.setText("Spacing:");

        jTextField_xAxis_TickMarks_Spacing.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_TickMarks_Spacing.setToolTipText("Set Real Number");
        jTextField_xAxis_TickMarks_Spacing.setInputVerifier(verifyFloat);
        jTextField_xAxis_TickMarks_Spacing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_xAxis_TickMarks_SpacingActionPerformed(evt);
            }
        });

        jLabel_xAxis_TickMarks_Color.setText("Color:");

        jPanel_xAxis_TickMarks_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_xAxis_TickMarks_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_xAxis_TickMarks_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_xAxis_TickMarks_ColorLayout = new javax.swing.GroupLayout(jPanel_xAxis_TickMarks_Color);
        jPanel_xAxis_TickMarks_Color.setLayout(jPanel_xAxis_TickMarks_ColorLayout);
        jPanel_xAxis_TickMarks_ColorLayout.setHorizontalGroup(
            jPanel_xAxis_TickMarks_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_xAxis_TickMarks_ColorLayout.setVerticalGroup(
            jPanel_xAxis_TickMarks_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jTextField_xAxis_TickMarks_Length.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_TickMarks_Length.setToolTipText("Set Real Number");
        jTextField_xAxis_TickMarks_Length.setInputVerifier(verifyFloat);
        jTextField_xAxis_TickMarks_Length.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_xAxis_TickMarks_LengthActionPerformed(evt);
            }
        });

        jLabel_xAxis_TickMarks_Length.setText("Length:");

        javax.swing.GroupLayout jPanel_xAxis_TickMarksLayout = new javax.swing.GroupLayout(jPanel_xAxis_TickMarks);
        jPanel_xAxis_TickMarks.setLayout(jPanel_xAxis_TickMarksLayout);
        jPanel_xAxis_TickMarksLayout.setHorizontalGroup(
            jPanel_xAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_TickMarksLayout.createSequentialGroup()
                .addGroup(jPanel_xAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_xAxis_TickMarksLayout.createSequentialGroup()
                        .addGroup(jPanel_xAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_xAxis_TickMarksLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel_xAxis_TickMarks_Size)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_xAxis_TickMarks_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_xAxis_TickMarksLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_xAxis_TickMarks_Color)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_xAxis_TickMarks_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_xAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_xAxis_TickMarks_Spacing, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_xAxis_TickMarks_Length, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_xAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_xAxis_TickMarks_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_xAxis_TickMarks_Length, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_xAxis_TickMarksLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jCheckBox_xAxis_TickMarks_On))
                    .addGroup(jPanel_xAxis_TickMarksLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel_xAxis_TickMarks_On)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_xAxis_TickMarksLayout.setVerticalGroup(
            jPanel_xAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_TickMarksLayout.createSequentialGroup()
                .addGroup(jPanel_xAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_TickMarks_On)
                    .addComponent(jCheckBox_xAxis_TickMarks_On))
                .addGap(18, 18, 18)
                .addGroup(jPanel_xAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_TickMarks_Size)
                    .addComponent(jTextField_xAxis_TickMarks_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_xAxis_TickMarks_Spacing)
                    .addComponent(jTextField_xAxis_TickMarks_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_xAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_TickMarks_Color)
                    .addComponent(jPanel_xAxis_TickMarks_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_xAxis_TickMarks_Length)
                    .addComponent(jTextField_xAxis_TickMarks_Length, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_xAxis_TickLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tick Label"));

        jLabel_xAxis_TickLabel_On.setText("On:");

        jCheckBox_xAxis_TickLabel_On.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_xAxis_TickLabel_OnActionPerformed(evt);
            }
        });

        jLabel_xAxis_TickLabel_Font.setText("Font:");

        jComboBox_xAxis_TickLabel_Font.setEditable(true);
        jComboBox_xAxis_TickLabel_Font.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arial", "Tahoma", "Serif", "Times" }));

        jLabel_xAxis_TickLabel_FontSize.setText("Size:");

        jTextField_xAxis_TickLabel_FontSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_TickLabel_FontSize.setToolTipText("Set Real Number");
        jTextField_xAxis_TickLabel_FontSize.setInputVerifier(verifyInt);
        jTextField_xAxis_TickLabel_FontSize.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel_xAxis_TickLabel_Color.setText("Color:");

        jPanel_xAxis_TickLabel_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_xAxis_TickLabel_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_xAxis_TickLabel_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_xAxis_TickLabel_ColorLayout = new javax.swing.GroupLayout(jPanel_xAxis_TickLabel_Color);
        jPanel_xAxis_TickLabel_Color.setLayout(jPanel_xAxis_TickLabel_ColorLayout);
        jPanel_xAxis_TickLabel_ColorLayout.setHorizontalGroup(
            jPanel_xAxis_TickLabel_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_xAxis_TickLabel_ColorLayout.setVerticalGroup(
            jPanel_xAxis_TickLabel_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_xAxis_TickLabel_xAlign.setText("xAlign:");

        jTextField_xAxis_TickLabel_xAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_TickLabel_xAlign.setToolTipText("Set Integer");
        jTextField_xAxis_TickLabel_xAlign.setInputVerifier(verifyFloat);

        jLabel_xAxis_TickLabel_yAlign.setText("yAlign:");

        jTextField_xAxis_TickLabel_yAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_TickLabel_yAlign.setToolTipText("Set Integer");
        jTextField_xAxis_TickLabel_yAlign.setInputVerifier(verifyFloat);
        jTextField_xAxis_TickLabel_yAlign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_xAxis_TickLabel_yAlignActionPerformed(evt);
            }
        });

        jTextField_xAxis_TickLabel_Spacing.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_xAxis_TickLabel_Spacing.setToolTipText("Set Real Number");
        jTextField_xAxis_TickLabel_Spacing.setInputVerifier(verifyFloat);
        jTextField_xAxis_TickLabel_Spacing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_xAxis_TickLabel_SpacingActionPerformed(evt);
            }
        });

        jLabel_xAxis_TickLabel_Spacing.setText("Spacing:");

        javax.swing.GroupLayout jPanel_xAxis_TickLabelLayout = new javax.swing.GroupLayout(jPanel_xAxis_TickLabel);
        jPanel_xAxis_TickLabel.setLayout(jPanel_xAxis_TickLabelLayout);
        jPanel_xAxis_TickLabelLayout.setHorizontalGroup(
            jPanel_xAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_TickLabelLayout.createSequentialGroup()
                .addGroup(jPanel_xAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_xAxis_TickLabelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel_xAxis_TickLabel_On))
                    .addGroup(jPanel_xAxis_TickLabelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jCheckBox_xAxis_TickLabel_On)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_xAxis_TickLabel_Font)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_xAxis_TickLabel_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_xAxis_TickLabelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel_xAxis_TickLabel_FontSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_xAxis_TickLabel_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel_xAxis_TickLabel_Color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_xAxis_TickLabel_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_xAxis_TickLabelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_xAxis_TickLabel_xAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_xAxis_TickLabel_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_xAxis_TickLabel_yAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_xAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_xAxis_TickLabel_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_xAxis_TickLabelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel_xAxis_TickLabel_Spacing)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_xAxis_TickLabel_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_xAxis_TickLabelLayout.setVerticalGroup(
            jPanel_xAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxis_TickLabelLayout.createSequentialGroup()
                .addGroup(jPanel_xAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_TickLabel_On)
                    .addComponent(jCheckBox_xAxis_TickLabel_On)
                    .addComponent(jLabel_xAxis_TickLabel_Font)
                    .addComponent(jComboBox_xAxis_TickLabel_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_xAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_TickLabel_FontSize)
                    .addComponent(jTextField_xAxis_TickLabel_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_xAxis_TickLabel_Color)
                    .addComponent(jPanel_xAxis_TickLabel_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_xAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_xAxis_TickLabel_xAlign)
                    .addComponent(jTextField_xAxis_TickLabel_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_xAxis_TickLabel_yAlign)
                    .addComponent(jTextField_xAxis_TickLabel_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_xAxis_TickLabel_Spacing)
                    .addComponent(jTextField_xAxis_TickLabel_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_xAxisLayout = new javax.swing.GroupLayout(jPanel_xAxis);
        jPanel_xAxis.setLayout(jPanel_xAxisLayout);
        jPanel_xAxisLayout.setHorizontalGroup(
            jPanel_xAxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_xAxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_xAxisLayout.createSequentialGroup()
                        .addComponent(jPanel_xAxis_Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_xAxis_Axis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_xAxisLayout.createSequentialGroup()
                        .addGroup(jPanel_xAxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_xAxisLayout.createSequentialGroup()
                                .addComponent(jPanel_xAxis_Line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel_xAxis_Grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel_xAxisLayout.createSequentialGroup()
                                .addComponent(jPanel_xAxis_TickMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel_xAxis_TickLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(222, 222, 222)))
                .addContainerGap())
        );
        jPanel_xAxisLayout.setVerticalGroup(
            jPanel_xAxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_xAxisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_xAxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel_xAxis_Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_xAxis_Axis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel_xAxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_xAxis_Grid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_xAxis_Line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel_xAxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_xAxis_TickMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_xAxis_TickLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane.addTab("X - Axis", jPanel_xAxis);

        jPanel_yAxis_Label.setBorder(javax.swing.BorderFactory.createTitledBorder("Label"));

        jLabel_yAxis_Label_Text.setText("Text:");

        jLabel_yAxis_Label_Font.setText("Font:");

        jComboBox_yAxis_Label_Font.setEditable(true);
        jComboBox_yAxis_Label_Font.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arial", "Tahoma", "Serif", "Times" }));

        jLabel_yAxis_Label_Color.setText("Color:");

        jPanel_yAxis_Label_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_yAxis_Label_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_yAxis_Label_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_yAxis_Label_ColorLayout = new javax.swing.GroupLayout(jPanel_yAxis_Label_Color);
        jPanel_yAxis_Label_Color.setLayout(jPanel_yAxis_Label_ColorLayout);
        jPanel_yAxis_Label_ColorLayout.setHorizontalGroup(
            jPanel_yAxis_Label_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_yAxis_Label_ColorLayout.setVerticalGroup(
            jPanel_yAxis_Label_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_yAxis_Label_FontSize.setText("Size:");

        jTextField_yAxis_Label_FontSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Label_FontSize.setToolTipText("Set Integer");
        jTextField_yAxis_Label_FontSize.setInputVerifier(verifyInt);
        jTextField_yAxis_Label_FontSize.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel_yAxis_Label_xAlign.setText("xAlign:");

        jTextField_yAxis_Label_xAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Label_xAlign.setToolTipText("Set Integer");
        jTextField_yAxis_Label_xAlign.setInputVerifier(verifyFloat);

        jLabel_yAxis_Label_yAlign.setText("yAlign:");

        jTextField_yAxis_Label_yAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Label_yAlign.setToolTipText("Set Integer");
        jTextField_yAxis_Label_yAlign.setInputVerifier(verifyFloat);
        jTextField_yAxis_Label_yAlign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_yAxis_Label_yAlignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_yAxis_LabelLayout = new javax.swing.GroupLayout(jPanel_yAxis_Label);
        jPanel_yAxis_Label.setLayout(jPanel_yAxis_LabelLayout);
        jPanel_yAxis_LabelLayout.setHorizontalGroup(
            jPanel_yAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_LabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_yAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_yAxis_Label_Font, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_yAxis_Label_Text, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_yAxis_Label_FontSize, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_yAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_yAxis_Label_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_yAxis_LabelLayout.createSequentialGroup()
                        .addComponent(jComboBox_yAxis_Label_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_yAxis_Label_Color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_yAxis_Label_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_yAxis_LabelLayout.createSequentialGroup()
                        .addComponent(jTextField_yAxis_Label_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_yAxis_Label_xAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_yAxis_Label_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_yAxis_Label_yAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_yAxis_Label_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_yAxis_LabelLayout.setVerticalGroup(
            jPanel_yAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_LabelLayout.createSequentialGroup()
                .addGroup(jPanel_yAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_Label_Text)
                    .addComponent(jTextField_yAxis_Label_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel_yAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_Label_Font)
                    .addComponent(jComboBox_yAxis_Label_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_yAxis_Label_Color)
                    .addComponent(jPanel_yAxis_Label_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_yAxis_LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_Label_FontSize)
                    .addComponent(jTextField_yAxis_Label_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_yAxis_Label_xAlign)
                    .addComponent(jTextField_yAxis_Label_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_yAxis_Label_yAlign)
                    .addComponent(jTextField_yAxis_Label_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_yAxis_Axis.setBorder(javax.swing.BorderFactory.createTitledBorder("Axis"));

        jLabel_yAxis_Auto.setText("Auto:");

        jCheckBox_yAxis_Auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_yAxis_AutoActionPerformed(evt);
            }
        });

        jLabel_yAxis_Min.setText("Min:");

        jTextField_yAxis_Min.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Min.setToolTipText("Set Real Number");
        jTextField_yAxis_Min.setInputVerifier(verifyFloat);
        jTextField_yAxis_Min.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel_yAxis_Max.setText("Max:");

        jTextField_yAxis_Max.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Max.setToolTipText("Set Real Number");
        jTextField_yAxis_Max.setInputVerifier(verifyFloat);
        jTextField_yAxis_Max.setPreferredSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout jPanel_yAxis_AxisLayout = new javax.swing.GroupLayout(jPanel_yAxis_Axis);
        jPanel_yAxis_Axis.setLayout(jPanel_yAxis_AxisLayout);
        jPanel_yAxis_AxisLayout.setHorizontalGroup(
            jPanel_yAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_AxisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_yAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_yAxis_Min, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_yAxis_Auto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_yAxis_Max, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_yAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_yAxis_Auto)
                    .addComponent(jTextField_yAxis_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_yAxis_Max, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_yAxis_AxisLayout.setVerticalGroup(
            jPanel_yAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_AxisLayout.createSequentialGroup()
                .addGroup(jPanel_yAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_yAxis_Auto)
                    .addComponent(jCheckBox_yAxis_Auto))
                .addGap(11, 11, 11)
                .addGroup(jPanel_yAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_yAxis_Min)
                    .addComponent(jTextField_yAxis_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_yAxis_AxisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_yAxis_Max)
                    .addComponent(jTextField_yAxis_Max, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_yAxis_Line.setBorder(javax.swing.BorderFactory.createTitledBorder("Line"));

        jLabel_yAxis_Line_Size.setText("Size:");

        jTextField_yAxis_Line_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Line_Size.setToolTipText("Set Real Number");
        jTextField_yAxis_Line_Size.setInputVerifier(verifyFloat);

        jLabel_yAxis_Line_Color.setText("Color:");

        jPanel_yAxis_Line_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_yAxis_Line_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_yAxis_Line_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_yAxis_Line_ColorLayout = new javax.swing.GroupLayout(jPanel_yAxis_Line_Color);
        jPanel_yAxis_Line_Color.setLayout(jPanel_yAxis_Line_ColorLayout);
        jPanel_yAxis_Line_ColorLayout.setHorizontalGroup(
            jPanel_yAxis_Line_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_yAxis_Line_ColorLayout.setVerticalGroup(
            jPanel_yAxis_Line_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_yAxis_Line_Style.setText("Style:");

        jTextField_yAxis_Line_Style1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Line_Style1.setToolTipText("Set Real Number");
        jTextField_yAxis_Line_Style1.setInputVerifier(verifyFloat);

        jTextField_yAxis_Line_Style2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Line_Style2.setToolTipText("Set Real Number");
        jTextField_yAxis_Line_Style2.setInputVerifier(verifyFloat);

        jTextField_yAxis_Line_Style3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Line_Style3.setToolTipText("Set Real Number");
        jTextField_yAxis_Line_Style3.setInputVerifier(verifyFloat);

        jTextField_yAxis_Line_Style4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Line_Style4.setToolTipText("Set Real Number");
        jTextField_yAxis_Line_Style4.setInputVerifier(verifyFloat);

        javax.swing.GroupLayout jPanel_yAxis_LineLayout = new javax.swing.GroupLayout(jPanel_yAxis_Line);
        jPanel_yAxis_Line.setLayout(jPanel_yAxis_LineLayout);
        jPanel_yAxis_LineLayout.setHorizontalGroup(
            jPanel_yAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_LineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_yAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_yAxis_LineLayout.createSequentialGroup()
                        .addGroup(jPanel_yAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_yAxis_Line_Color, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_yAxis_Line_Size, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_yAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel_yAxis_Line_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_yAxis_Line_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_yAxis_LineLayout.createSequentialGroup()
                        .addComponent(jLabel_yAxis_Line_Style)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_yAxis_Line_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_yAxis_Line_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_yAxis_Line_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_yAxis_Line_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_yAxis_LineLayout.setVerticalGroup(
            jPanel_yAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_LineLayout.createSequentialGroup()
                .addGroup(jPanel_yAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_Line_Color)
                    .addComponent(jPanel_yAxis_Line_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_yAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_Line_Size)
                    .addComponent(jTextField_yAxis_Line_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_yAxis_LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_Line_Style)
                    .addComponent(jTextField_yAxis_Line_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_yAxis_Line_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_yAxis_Line_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_yAxis_Line_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_yAxis_Grid.setBorder(javax.swing.BorderFactory.createTitledBorder("Grid"));

        jLabel_yAxis_Grid_On.setText("On:");

        jCheckBox_yAxis_Grid_On.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_yAxis_Grid_OnActionPerformed(evt);
            }
        });

        jLabel_yAxis_Grid_Color.setText("Color:");

        jPanel_yAxis_Grid_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_yAxis_Grid_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_yAxis_Grid_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_yAxis_Grid_ColorLayout = new javax.swing.GroupLayout(jPanel_yAxis_Grid_Color);
        jPanel_yAxis_Grid_Color.setLayout(jPanel_yAxis_Grid_ColorLayout);
        jPanel_yAxis_Grid_ColorLayout.setHorizontalGroup(
            jPanel_yAxis_Grid_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_yAxis_Grid_ColorLayout.setVerticalGroup(
            jPanel_yAxis_Grid_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_yAxis_Grid_Size.setText("Size:");

        jTextField_yAxis_Grid_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Grid_Size.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Size.setInputVerifier(verifyFloat);

        jLabel__yAxis_Grid_Spacing.setText("Spacing:");

        jTextField_yAxis_Grid_Spacing.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Grid_Spacing.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Spacing.setInputVerifier(verifyFloat);
        jTextField_yAxis_Grid_Spacing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_yAxis_Grid_SpacingActionPerformed(evt);
            }
        });

        jLabel_yAxis_Grid_Style.setText("Style:");

        jTextField_yAxis_Grid_Style1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Grid_Style1.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Style1.setInputVerifier(verifyFloat);

        jTextField_yAxis_Grid_Style2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Grid_Style2.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Style2.setInputVerifier(verifyFloat);

        jTextField_yAxis_Grid_Style3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Grid_Style3.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Style3.setInputVerifier(verifyFloat);

        jTextField_yAxis_Grid_Style4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_Grid_Style4.setToolTipText("Set Real Number");
        jTextField_yAxis_Grid_Style4.setInputVerifier(verifyFloat);

        javax.swing.GroupLayout jPanel_yAxis_GridLayout = new javax.swing.GroupLayout(jPanel_yAxis_Grid);
        jPanel_yAxis_Grid.setLayout(jPanel_yAxis_GridLayout);
        jPanel_yAxis_GridLayout.setHorizontalGroup(
            jPanel_yAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_GridLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_yAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_yAxis_Grid_On, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_yAxis_Grid_Size, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_yAxis_Grid_Style, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_yAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_yAxis_GridLayout.createSequentialGroup()
                        .addComponent(jCheckBox_yAxis_Grid_On)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_yAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_yAxis_GridLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jPanel_yAxis_Grid_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel_yAxis_Grid_Color)))
                    .addGroup(jPanel_yAxis_GridLayout.createSequentialGroup()
                        .addComponent(jTextField_yAxis_Grid_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel__yAxis_Grid_Spacing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_yAxis_Grid_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_yAxis_GridLayout.createSequentialGroup()
                        .addComponent(jTextField_yAxis_Grid_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_yAxis_Grid_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_yAxis_Grid_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_yAxis_Grid_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel_yAxis_GridLayout.setVerticalGroup(
            jPanel_yAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_GridLayout.createSequentialGroup()
                .addGroup(jPanel_yAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_Grid_On)
                    .addComponent(jCheckBox_yAxis_Grid_On)
                    .addComponent(jPanel_yAxis_Grid_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_yAxis_Grid_Color))
                .addGap(18, 18, 18)
                .addGroup(jPanel_yAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_Grid_Size)
                    .addComponent(jTextField_yAxis_Grid_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel__yAxis_Grid_Spacing)
                    .addComponent(jTextField_yAxis_Grid_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_yAxis_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_Grid_Style)
                    .addComponent(jTextField_yAxis_Grid_Style1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_yAxis_Grid_Style2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_yAxis_Grid_Style3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_yAxis_Grid_Style4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_yAxis_TickMarks.setBorder(javax.swing.BorderFactory.createTitledBorder("Tick Marks"));

        jLabel_yAxis_TickMarks_On.setText("On:");

        jCheckBox_yAxis_TickMarks_On.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_yAxis_TickMarks_OnActionPerformed(evt);
            }
        });

        jLabel_yAxis_TickMarks_Size.setText("Size:");

        jTextField_yAxis_TickMarks_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_TickMarks_Size.setToolTipText("Set Real Number");
        jTextField_yAxis_TickMarks_Size.setInputVerifier(verifyFloat);

        jLabel_yAxis_TickMarks_Spacing.setText("Spacing:");

        jTextField_yAxis_TickMarks_Spacing.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_TickMarks_Spacing.setToolTipText("Set Real Number");
        jTextField_yAxis_TickMarks_Spacing.setInputVerifier(verifyFloat);
        jTextField_yAxis_TickMarks_Spacing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_yAxis_TickMarks_SpacingActionPerformed(evt);
            }
        });

        jLabel_yAxis_TickMarks_Color.setText("Color:");

        jPanel_yAxis_TickMarks_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_yAxis_TickMarks_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_yAxis_TickMarks_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_yAxis_TickMarks_ColorLayout = new javax.swing.GroupLayout(jPanel_yAxis_TickMarks_Color);
        jPanel_yAxis_TickMarks_Color.setLayout(jPanel_yAxis_TickMarks_ColorLayout);
        jPanel_yAxis_TickMarks_ColorLayout.setHorizontalGroup(
            jPanel_yAxis_TickMarks_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_yAxis_TickMarks_ColorLayout.setVerticalGroup(
            jPanel_yAxis_TickMarks_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jTextField_yAxis_TickMarks_Length.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_TickMarks_Length.setToolTipText("Set Real Number");
        jTextField_yAxis_TickMarks_Length.setInputVerifier(verifyFloat);
        jTextField_yAxis_TickMarks_Length.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_yAxis_TickMarks_LengthActionPerformed(evt);
            }
        });

        jLabel_yAxis_TickMarks_Length.setText("Length:");

        javax.swing.GroupLayout jPanel_yAxis_TickMarksLayout = new javax.swing.GroupLayout(jPanel_yAxis_TickMarks);
        jPanel_yAxis_TickMarks.setLayout(jPanel_yAxis_TickMarksLayout);
        jPanel_yAxis_TickMarksLayout.setHorizontalGroup(
            jPanel_yAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_TickMarksLayout.createSequentialGroup()
                .addGroup(jPanel_yAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_yAxis_TickMarksLayout.createSequentialGroup()
                        .addGroup(jPanel_yAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_yAxis_TickMarksLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel_yAxis_TickMarks_Size)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_yAxis_TickMarks_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_yAxis_TickMarksLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_yAxis_TickMarks_Color)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_yAxis_TickMarks_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_yAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_yAxis_TickMarks_Spacing, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_yAxis_TickMarks_Length, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_yAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_yAxis_TickMarks_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_yAxis_TickMarks_Length, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_yAxis_TickMarksLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jCheckBox_yAxis_TickMarks_On))
                    .addGroup(jPanel_yAxis_TickMarksLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel_yAxis_TickMarks_On)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_yAxis_TickMarksLayout.setVerticalGroup(
            jPanel_yAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_TickMarksLayout.createSequentialGroup()
                .addGroup(jPanel_yAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_TickMarks_On)
                    .addComponent(jCheckBox_yAxis_TickMarks_On))
                .addGap(18, 18, 18)
                .addGroup(jPanel_yAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_TickMarks_Size)
                    .addComponent(jTextField_yAxis_TickMarks_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_yAxis_TickMarks_Spacing)
                    .addComponent(jTextField_yAxis_TickMarks_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_yAxis_TickMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_TickMarks_Color)
                    .addComponent(jPanel_yAxis_TickMarks_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_yAxis_TickMarks_Length)
                    .addComponent(jTextField_yAxis_TickMarks_Length, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_yAxis_TickLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tick Label"));

        jLabel_yAxis_TickLabel_On.setText("On:");

        jCheckBox_yAxis_TickLabel_On.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_yAxis_TickLabel_OnActionPerformed(evt);
            }
        });

        jLabel_yAxis_TickLabel_Font.setText("Font:");

        jComboBox_yAxis_TickLabel_Font.setEditable(true);
        jComboBox_yAxis_TickLabel_Font.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arial", "Tahoma", "Serif", "Times" }));

        jLabel_yAxis_TickLabel_FontSize.setText("Size:");

        jTextField_yAxis_TickLabel_FontSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_TickLabel_FontSize.setToolTipText("Set Real Number");
        jTextField_yAxis_TickLabel_FontSize.setInputVerifier(verifyInt);
        jTextField_yAxis_TickLabel_FontSize.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel_yAxis_TickLabel_Color.setText("Color:");

        jPanel_yAxis_TickLabel_Color.setBackground(new java.awt.Color(255, 153, 0));
        jPanel_yAxis_TickLabel_Color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_yAxis_TickLabel_ColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_yAxis_TickLabel_ColorLayout = new javax.swing.GroupLayout(jPanel_yAxis_TickLabel_Color);
        jPanel_yAxis_TickLabel_Color.setLayout(jPanel_yAxis_TickLabel_ColorLayout);
        jPanel_yAxis_TickLabel_ColorLayout.setHorizontalGroup(
            jPanel_yAxis_TickLabel_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel_yAxis_TickLabel_ColorLayout.setVerticalGroup(
            jPanel_yAxis_TickLabel_ColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel_yAxis_TickLabel_xAlign.setText("xAlign:");

        jTextField_yAxis_TickLabel_xAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_TickLabel_xAlign.setToolTipText("Set Integer");
        jTextField_yAxis_TickLabel_xAlign.setInputVerifier(verifyFloat);

        jLabel_yAxis_TickLabel_yAlign.setText("yAlign:");

        jTextField_yAxis_TickLabel_yAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_TickLabel_yAlign.setToolTipText("Set Integer");
        jTextField_yAxis_TickLabel_yAlign.setInputVerifier(verifyFloat);
        jTextField_yAxis_TickLabel_yAlign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_yAxis_TickLabel_yAlignActionPerformed(evt);
            }
        });

        jTextField_yAxis_TickLabel_Spacing.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_yAxis_TickLabel_Spacing.setToolTipText("Set Real Number");
        jTextField_yAxis_TickLabel_Spacing.setInputVerifier(verifyFloat);
        jTextField_yAxis_TickLabel_Spacing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_yAxis_TickLabel_SpacingActionPerformed(evt);
            }
        });

        jLabel_yAxis_TickLabel_Spacing.setText("Spacing:");

        javax.swing.GroupLayout jPanel_yAxis_TickLabelLayout = new javax.swing.GroupLayout(jPanel_yAxis_TickLabel);
        jPanel_yAxis_TickLabel.setLayout(jPanel_yAxis_TickLabelLayout);
        jPanel_yAxis_TickLabelLayout.setHorizontalGroup(
            jPanel_yAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_TickLabelLayout.createSequentialGroup()
                .addGroup(jPanel_yAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_yAxis_TickLabelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel_yAxis_TickLabel_On))
                    .addGroup(jPanel_yAxis_TickLabelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jCheckBox_yAxis_TickLabel_On)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_yAxis_TickLabel_Font)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_yAxis_TickLabel_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_yAxis_TickLabelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel_yAxis_TickLabel_FontSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_yAxis_TickLabel_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel_yAxis_TickLabel_Color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_yAxis_TickLabel_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_yAxis_TickLabelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_yAxis_TickLabel_xAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_yAxis_TickLabel_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_yAxis_TickLabel_yAlign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_yAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_yAxis_TickLabel_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_yAxis_TickLabelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel_yAxis_TickLabel_Spacing)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_yAxis_TickLabel_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_yAxis_TickLabelLayout.setVerticalGroup(
            jPanel_yAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis_TickLabelLayout.createSequentialGroup()
                .addGroup(jPanel_yAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_TickLabel_On)
                    .addComponent(jCheckBox_yAxis_TickLabel_On)
                    .addComponent(jLabel_yAxis_TickLabel_Font)
                    .addComponent(jComboBox_yAxis_TickLabel_Font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_yAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_TickLabel_FontSize)
                    .addComponent(jTextField_yAxis_TickLabel_FontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_yAxis_TickLabel_Color)
                    .addComponent(jPanel_yAxis_TickLabel_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_yAxis_TickLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel_yAxis_TickLabel_xAlign)
                    .addComponent(jTextField_yAxis_TickLabel_xAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_yAxis_TickLabel_yAlign)
                    .addComponent(jTextField_yAxis_TickLabel_yAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_yAxis_TickLabel_Spacing)
                    .addComponent(jTextField_yAxis_TickLabel_Spacing, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_yAxis1Layout = new javax.swing.GroupLayout(jPanel_yAxis1);
        jPanel_yAxis1.setLayout(jPanel_yAxis1Layout);
        jPanel_yAxis1Layout.setHorizontalGroup(
            jPanel_yAxis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_yAxis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_yAxis1Layout.createSequentialGroup()
                        .addComponent(jPanel_yAxis_Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_yAxis_Axis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_yAxis1Layout.createSequentialGroup()
                        .addGroup(jPanel_yAxis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_yAxis1Layout.createSequentialGroup()
                                .addComponent(jPanel_yAxis_Line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel_yAxis_Grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel_yAxis1Layout.createSequentialGroup()
                                .addComponent(jPanel_yAxis_TickMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel_yAxis_TickLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(222, 222, 222)))
                .addContainerGap())
        );
        jPanel_yAxis1Layout.setVerticalGroup(
            jPanel_yAxis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_yAxis1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_yAxis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel_yAxis_Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_yAxis_Axis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel_yAxis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_yAxis_Line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_yAxis_Grid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel_yAxis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_yAxis_TickMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_yAxis_TickLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane.addTab("Y - Axis", jPanel_yAxis1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_plot_Line_Style1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_plot_Line_Style1ActionPerformed
    }//GEN-LAST:event_jTextField_plot_Line_Style1ActionPerformed

    private void jTextField_xAxis_Grid_SpacingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_xAxis_Grid_SpacingActionPerformed
    }//GEN-LAST:event_jTextField_xAxis_Grid_SpacingActionPerformed

    private void jButton_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OkActionPerformed
        getNewSettings();
        dialogOkSuccess = true;
        if (parentPlot != null) {
            parentPlot.setNewValues();
            parentPlot.repaint();
        }
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton_OkActionPerformed

    private void jButton_ApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ApplyActionPerformed
        getNewSettings();
        dialogOkSuccess = true;
        if (parentPlot != null) {
            parentPlot.setNewValues();
            parentPlot.repaint();
        }
    }//GEN-LAST:event_jButton_ApplyActionPerformed

    private void jButton_DefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DefaultActionPerformed
        setDefaultValues();
        setSettings();
    }//GEN-LAST:event_jButton_DefaultActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jPanel_plot_Line_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_plot_Line_ColorMouseClicked
        Color initialBackground = jPanel_plot_Line_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Plot Line Color", initialBackground);
        if (background != null) {
            jPanel_plot_Line_Color.setBackground(background);
        }
    }//GEN-LAST:event_jPanel_plot_Line_ColorMouseClicked

    private void jPanel_plot_Marker_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_plot_Marker_ColorMouseClicked
        Color initialBackground = jPanel_plot_Marker_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Plot Marker Color", initialBackground);
        if (background != null) {
            jPanel_plot_Marker_Color.setBackground(background);
        }
    }//GEN-LAST:event_jPanel_plot_Marker_ColorMouseClicked

    private void jPanel_plot_Marker_FillColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_plot_Marker_FillColorMouseClicked
        Color initialBackground = jPanel_plot_Marker_FillColor.getBackground();
        Color background = JColorChooser.showDialog(null, "Plot Marker Fill Color", initialBackground);
        if (background != null) {
            jPanel_plot_Marker_FillColor.setBackground(background);
        }
    }//GEN-LAST:event_jPanel_plot_Marker_FillColorMouseClicked

    private void jPanel_xAxis_Line_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_xAxis_Line_ColorMouseClicked
        Color initialBackground = jPanel_xAxis_Line_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "X Axis Line Color", initialBackground);
        if (background != null) {
            jPanel_xAxis_Line_Color.setBackground(background);
        }
   }//GEN-LAST:event_jPanel_xAxis_Line_ColorMouseClicked

    private void jPanel_xAxis_Grid_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_xAxis_Grid_ColorMouseClicked
        Color initialBackground = jPanel_xAxis_Grid_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "X Axis Grid Line Color", initialBackground);
        if (background != null) {
            jPanel_xAxis_Grid_Color.setBackground(background);
        }
    }//GEN-LAST:event_jPanel_xAxis_Grid_ColorMouseClicked

    private void jPanel_plot_Box_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_plot_Box_ColorMouseClicked
        Color initialBackground = jPanel_plot_Box_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Plot Box Line Color", initialBackground);
        if (background != null) {
            jPanel_plot_Box_Color.setBackground(background);
        }
    }//GEN-LAST:event_jPanel_plot_Box_ColorMouseClicked

    private void jPanel_plot_Box_FillColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_plot_Box_FillColorMouseClicked
        Color initialBackground = jPanel_plot_Box_FillColor.getBackground();
        Color background = JColorChooser.showDialog(null, "Plot Box Fill Color", initialBackground);
        if (background != null) {
            jPanel_plot_Box_FillColor.setBackground(background);
        }
    }//GEN-LAST:event_jPanel_plot_Box_FillColorMouseClicked

    private void jTextField_xAxis_TickMarks_SpacingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_xAxis_TickMarks_SpacingActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_xAxis_TickMarks_SpacingActionPerformed

    private void jPanel_xAxis_TickMarks_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_xAxis_TickMarks_ColorMouseClicked
        Color initialBackground = jPanel_xAxis_TickMarks_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "X Axis Tick Marks Line Color", initialBackground);
        if (background != null) {
            jPanel_xAxis_TickMarks_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_xAxis_TickMarks_ColorMouseClicked

    private void jPanel_xAxis_Label_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_xAxis_Label_ColorMouseClicked
        Color initialBackground = jPanel_xAxis_Label_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "X Axis Label Color", initialBackground);
        if (background != null) {
            jPanel_xAxis_Label_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_xAxis_Label_ColorMouseClicked

    private void jPanel_xAxis_TickLabel_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_xAxis_TickLabel_ColorMouseClicked
        Color initialBackground = jPanel_xAxis_TickLabel_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "X Axis Tick Label Color", initialBackground);
        if (background != null) {
            jPanel_xAxis_TickLabel_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_xAxis_TickLabel_ColorMouseClicked

    private void jTextField_xAxis_TickLabel_yAlignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_xAxis_TickLabel_yAlignActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_xAxis_TickLabel_yAlignActionPerformed

    private void jTextField_xAxis_Label_yAlignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_xAxis_Label_yAlignActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_xAxis_Label_yAlignActionPerformed

    private void jTextField_plot_Title_yAlignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_plot_Title_yAlignActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_plot_Title_yAlignActionPerformed

    private void jPanel_yAxis_Label_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_yAxis_Label_ColorMouseClicked
        Color initialBackground = jPanel_yAxis_Label_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Y Axis Label Color", initialBackground);
        if (background != null) {
            jPanel_yAxis_Label_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_yAxis_Label_ColorMouseClicked

    private void jTextField_yAxis_Label_yAlignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_yAxis_Label_yAlignActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_yAxis_Label_yAlignActionPerformed

    private void jPanel_yAxis_Line_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_yAxis_Line_ColorMouseClicked
        Color initialBackground = jPanel_yAxis_Line_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Y Axis Color", initialBackground);
        if (background != null) {
            jPanel_yAxis_Line_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_yAxis_Line_ColorMouseClicked

    private void jPanel_yAxis_Grid_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_yAxis_Grid_ColorMouseClicked
        Color initialBackground = jPanel_yAxis_Grid_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Y Axis Grid Color", initialBackground);
        if (background != null) {
            jPanel_yAxis_Grid_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_yAxis_Grid_ColorMouseClicked

    private void jTextField_yAxis_Grid_SpacingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_yAxis_Grid_SpacingActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_yAxis_Grid_SpacingActionPerformed

    private void jTextField_yAxis_TickMarks_SpacingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_yAxis_TickMarks_SpacingActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_yAxis_TickMarks_SpacingActionPerformed

    private void jPanel_yAxis_TickMarks_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_yAxis_TickMarks_ColorMouseClicked
        Color initialBackground = jPanel_yAxis_TickMarks_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Y Axis Tick Marks Color", initialBackground);
        if (background != null) {
            jPanel_yAxis_TickMarks_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_yAxis_TickMarks_ColorMouseClicked

    private void jPanel_yAxis_TickLabel_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_yAxis_TickLabel_ColorMouseClicked
        Color initialBackground = jPanel_yAxis_TickLabel_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Y Axis Tick Label Color", initialBackground);
        if (background != null) {
            jPanel_yAxis_TickLabel_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_yAxis_TickLabel_ColorMouseClicked

    private void jTextField_yAxis_TickLabel_yAlignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_yAxis_TickLabel_yAlignActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_yAxis_TickLabel_yAlignActionPerformed

    private void jPanel_plot_Title_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_plot_Title_ColorMouseClicked
        Color initialBackground = jPanel_plot_Title_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Plot Title Color", initialBackground);
        if (background != null) {
            jPanel_plot_Title_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_plot_Title_ColorMouseClicked

    private void jTextField_plot_Box_Style1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_plot_Box_Style1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_plot_Box_Style1ActionPerformed

    private void jTextField_plot_Box_Style4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_plot_Box_Style4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_plot_Box_Style4ActionPerformed

    private void jTextField_plot_Marker_Style1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_plot_Marker_Style1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_plot_Marker_Style1ActionPerformed

    private void jPanel_plot_Background_ColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_plot_Background_ColorMouseClicked
        Color initialBackground = jPanel_plot_Background_Color.getBackground();
        Color background = JColorChooser.showDialog(null, "Plot Background Color", initialBackground);
        if (background != null) {
            jPanel_plot_Background_Color.setBackground(background);
        }
}//GEN-LAST:event_jPanel_plot_Background_ColorMouseClicked

    private void jTextField_yAxis_TickMarks_LengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_yAxis_TickMarks_LengthActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_yAxis_TickMarks_LengthActionPerformed

    private void jTextField_xAxis_TickMarks_LengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_xAxis_TickMarks_LengthActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_xAxis_TickMarks_LengthActionPerformed

    private void jTextField_xAxis_TickLabel_SpacingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_xAxis_TickLabel_SpacingActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_xAxis_TickLabel_SpacingActionPerformed

    private void jTextField_yAxis_TickLabel_SpacingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_yAxis_TickLabel_SpacingActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField_yAxis_TickLabel_SpacingActionPerformed

    private void jCheckBox_xAxis_AutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_xAxis_AutoActionPerformed

        if (jCheckBox_xAxis_Auto.isSelected()) {
            jTextField_xAxis_Min.setEditable(false);
            jTextField_xAxis_Max.setEditable(false);
        }
        else {
            jTextField_xAxis_Min.setEditable(true);
            jTextField_xAxis_Max.setEditable(true);
        }

    }//GEN-LAST:event_jCheckBox_xAxis_AutoActionPerformed

    private void jCheckBox_yAxis_AutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_yAxis_AutoActionPerformed
        if (jCheckBox_yAxis_Auto.isSelected()) {
            jTextField_yAxis_Min.setEditable(false);
            jTextField_yAxis_Max.setEditable(false);
        }
        else {
            jTextField_yAxis_Min.setEditable(true);
            jTextField_yAxis_Max.setEditable(true);
        }
    }//GEN-LAST:event_jCheckBox_yAxis_AutoActionPerformed

    private void jCheckBox_xAxis_Grid_OnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_xAxis_Grid_OnActionPerformed
        if (!jCheckBox_xAxis_Grid_On.isSelected()) {
            jTextField_xAxis_Grid_Size.setEditable(false);
            jTextField_xAxis_Grid_Spacing.setEditable(false);
            jTextField_xAxis_Grid_Style1.setEditable(false);
            jTextField_xAxis_Grid_Style2.setEditable(false);
            jTextField_xAxis_Grid_Style3.setEditable(false);
            jTextField_xAxis_Grid_Style4.setEditable(false);
            jPanel_xAxis_Grid_Color.setVisible(false);

        }
        else {
            jTextField_xAxis_Grid_Size.setEditable(true);
            jTextField_xAxis_Grid_Spacing.setEditable(true);
            jTextField_xAxis_Grid_Style1.setEditable(true);
            jTextField_xAxis_Grid_Style2.setEditable(true);
            jTextField_xAxis_Grid_Style3.setEditable(true);
            jTextField_xAxis_Grid_Style4.setEditable(true);
            jPanel_xAxis_Grid_Color.setVisible(true);
        }
    }//GEN-LAST:event_jCheckBox_xAxis_Grid_OnActionPerformed

    private void jCheckBox_yAxis_Grid_OnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_yAxis_Grid_OnActionPerformed
        if (!jCheckBox_yAxis_Grid_On.isSelected()) {
            jTextField_yAxis_Grid_Size.setEditable(false);
            jTextField_yAxis_Grid_Spacing.setEditable(false);
            jTextField_yAxis_Grid_Style1.setEditable(false);
            jTextField_yAxis_Grid_Style2.setEditable(false);
            jTextField_yAxis_Grid_Style3.setEditable(false);
            jTextField_yAxis_Grid_Style4.setEditable(false);
            jPanel_yAxis_Grid_Color.setVisible(false);

        }
        else {
            jTextField_yAxis_Grid_Size.setEditable(true);
            jTextField_yAxis_Grid_Spacing.setEditable(true);
            jTextField_yAxis_Grid_Style1.setEditable(true);
            jTextField_yAxis_Grid_Style2.setEditable(true);
            jTextField_yAxis_Grid_Style3.setEditable(true);
            jTextField_yAxis_Grid_Style4.setEditable(true);
            jPanel_yAxis_Grid_Color.setVisible(true);
        }
    }//GEN-LAST:event_jCheckBox_yAxis_Grid_OnActionPerformed

    private void jCheckBox_xAxis_TickMarks_OnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_xAxis_TickMarks_OnActionPerformed
        if (!jCheckBox_xAxis_TickMarks_On.isSelected()) {
            jTextField_xAxis_TickMarks_Size.setEditable(false);
            jTextField_xAxis_TickMarks_Spacing.setEditable(false);
            jPanel_xAxis_TickMarks_Color.setVisible(false);
            jTextField_xAxis_TickMarks_Length.setEditable(false);
        }
        else {
            jTextField_xAxis_TickMarks_Size.setEditable(true);
            jTextField_xAxis_TickMarks_Spacing.setEditable(true);
            jPanel_xAxis_TickMarks_Color.setVisible(true);
            jTextField_xAxis_TickMarks_Length.setEditable(true);
        }
    }//GEN-LAST:event_jCheckBox_xAxis_TickMarks_OnActionPerformed

    private void jCheckBox_xAxis_TickLabel_OnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_xAxis_TickLabel_OnActionPerformed
        if (!jCheckBox_xAxis_TickLabel_On.isSelected()) {
            jComboBox_xAxis_TickLabel_Font.setEditable(false);
            jTextField_xAxis_TickLabel_FontSize.setEditable(false);
            jPanel_xAxis_TickLabel_Color.setVisible(false);
            jTextField_xAxis_TickLabel_xAlign.setEditable(false);
            jTextField_xAxis_TickLabel_yAlign.setEditable(false);
            jTextField_xAxis_TickLabel_Spacing.setEditable(false);
        }
        else {
            jComboBox_xAxis_TickLabel_Font.setEditable(true);
            jTextField_xAxis_TickLabel_FontSize.setEditable(true);
            jPanel_xAxis_TickLabel_Color.setVisible(true);
            jTextField_xAxis_TickLabel_xAlign.setEditable(true);
            jTextField_xAxis_TickLabel_yAlign.setEditable(true);
            jTextField_xAxis_TickLabel_Spacing.setEditable(true);
        }
    }//GEN-LAST:event_jCheckBox_xAxis_TickLabel_OnActionPerformed

    private void jCheckBox_yAxis_TickMarks_OnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_yAxis_TickMarks_OnActionPerformed
        if (!jCheckBox_yAxis_TickMarks_On.isSelected()) {
            jTextField_yAxis_TickMarks_Size.setEditable(false);
            jTextField_yAxis_TickMarks_Spacing.setEditable(false);
            jPanel_yAxis_TickMarks_Color.setVisible(false);
            jTextField_yAxis_TickMarks_Length.setEditable(false);
        }
        else {
            jTextField_yAxis_TickMarks_Size.setEditable(true);
            jTextField_yAxis_TickMarks_Spacing.setEditable(true);
            jPanel_yAxis_TickMarks_Color.setVisible(true);
            jTextField_yAxis_TickMarks_Length.setEditable(true);
        }
    }//GEN-LAST:event_jCheckBox_yAxis_TickMarks_OnActionPerformed

    private void jCheckBox_yAxis_TickLabel_OnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_yAxis_TickLabel_OnActionPerformed
        if (!jCheckBox_yAxis_TickLabel_On.isSelected()) {
            jComboBox_yAxis_TickLabel_Font.setEditable(false);
            jTextField_yAxis_TickLabel_FontSize.setEditable(false);
            jPanel_yAxis_TickLabel_Color.setVisible(false);
            jTextField_yAxis_TickLabel_xAlign.setEditable(false);
            jTextField_yAxis_TickLabel_yAlign.setEditable(false);
            jTextField_yAxis_TickLabel_Spacing.setEditable(false);
        }
        else {
            jComboBox_yAxis_TickLabel_Font.setEditable(true);
            jTextField_yAxis_TickLabel_FontSize.setEditable(true);
            jPanel_yAxis_TickLabel_Color.setVisible(true);
            jTextField_yAxis_TickLabel_xAlign.setEditable(true);
            jTextField_yAxis_TickLabel_yAlign.setEditable(true);
            jTextField_yAxis_TickLabel_Spacing.setEditable(true);
        }
    }//GEN-LAST:event_jCheckBox_yAxis_TickLabel_OnActionPerformed

    private void jCheckBox_plot_Marker_OnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_plot_Marker_OnActionPerformed
        if (!jCheckBox_plot_Marker_On.isSelected()) {
            jTextField_plot_Marker_Size.setEditable(false);
            jPanel_plot_Marker_Color.setVisible(false);
            jPanel_plot_Marker_FillColor.setVisible(false);
            jTextField_plot_Marker_Style1.setEditable(false);
            jTextField_plot_Marker_Style2.setEditable(false);
            jTextField_plot_Marker_Thickness.setEditable(false);
            jComboBox_plot_Marker_Type.setEditable(false);

        }
        else {
            jTextField_plot_Marker_Size.setEditable(true);
            jPanel_plot_Marker_Color.setVisible(true);
            jPanel_plot_Marker_FillColor.setVisible(true);
            jTextField_plot_Marker_Style1.setEditable(true);
            jTextField_plot_Marker_Style2.setEditable(true);
            jTextField_plot_Marker_Thickness.setEditable(true);
            jComboBox_plot_Marker_Type.setEditable(true);
        }
    }//GEN-LAST:event_jCheckBox_plot_Marker_OnActionPerformed

    private void jCheckBox_plot_Box_OnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_plot_Box_OnActionPerformed
        if (!jCheckBox_plot_Box_On.isSelected()) {
            jPanel_plot_Box_Color.setVisible(false);
            jPanel_plot_Box_FillColor.setVisible(false);
            jTextField_plot_Box_Size.setEditable(false);
            jTextField_plot_Box_Style1.setEditable(false);
            jTextField_plot_Box_Style2.setEditable(false);
            jTextField_plot_Box_Style3.setEditable(false);
            jTextField_plot_Box_Style4.setEditable(false);
            jTextField_plot_Box_Padding1.setEditable(false);
            jTextField_plot_Box_Padding2.setEditable(false);
            jTextField_plot_Box_Padding3.setEditable(false);
            jTextField_plot_Box_Padding4.setEditable(false);
        }
        else {
            jPanel_plot_Box_Color.setVisible(true);
            jPanel_plot_Box_FillColor.setVisible(true);
            jTextField_plot_Box_Size.setEditable(true);
            jTextField_plot_Box_Style1.setEditable(true);
            jTextField_plot_Box_Style2.setEditable(true);
            jTextField_plot_Box_Style3.setEditable(true);
            jTextField_plot_Box_Style4.setEditable(true);
            jTextField_plot_Box_Padding1.setEditable(true);
            jTextField_plot_Box_Padding2.setEditable(true);
            jTextField_plot_Box_Padding3.setEditable(true);
            jTextField_plot_Box_Padding4.setEditable(true);
        }

    }//GEN-LAST:event_jCheckBox_plot_Box_OnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //...........
        //    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //...........

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JDialog_Plot_Settings dialog = new JDialog_Plot_Settings(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Apply;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_Default;
    private javax.swing.JButton jButton_Ok;
    private javax.swing.JCheckBox jCheckBox_plot_Box_On;
    private javax.swing.JCheckBox jCheckBox_plot_Marker_On;
    private javax.swing.JCheckBox jCheckBox_xAxis_Auto;
    private javax.swing.JCheckBox jCheckBox_xAxis_Grid_On;
    private javax.swing.JCheckBox jCheckBox_xAxis_TickLabel_On;
    private javax.swing.JCheckBox jCheckBox_xAxis_TickMarks_On;
    private javax.swing.JCheckBox jCheckBox_yAxis_Auto;
    private javax.swing.JCheckBox jCheckBox_yAxis_Grid_On;
    private javax.swing.JCheckBox jCheckBox_yAxis_TickLabel_On;
    private javax.swing.JCheckBox jCheckBox_yAxis_TickMarks_On;
    private javax.swing.JComboBox jComboBox_plot_Line_Type;
    private javax.swing.JComboBox jComboBox_plot_Marker_Type;
    private javax.swing.JComboBox jComboBox_plot_Title_Font;
    private javax.swing.JComboBox jComboBox_xAxis_Label_Font;
    private javax.swing.JComboBox jComboBox_xAxis_TickLabel_Font;
    private javax.swing.JComboBox jComboBox_yAxis_Label_Font;
    private javax.swing.JComboBox jComboBox_yAxis_TickLabel_Font;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel__yAxis_Grid_Spacing;
    private javax.swing.JLabel jLabel_plot_Background_Color;
    private javax.swing.JLabel jLabel_plot_Box_Color;
    private javax.swing.JLabel jLabel_plot_Box_FillColor;
    private javax.swing.JLabel jLabel_plot_Box_On;
    private javax.swing.JLabel jLabel_plot_Box_Padding;
    private javax.swing.JLabel jLabel_plot_Box_Size;
    private javax.swing.JLabel jLabel_plot_Box_Style;
    private javax.swing.JLabel jLabel_plot_Line_Color;
    private javax.swing.JLabel jLabel_plot_Line_Size;
    private javax.swing.JLabel jLabel_plot_Line_Style;
    private javax.swing.JLabel jLabel_plot_Line_Type;
    private javax.swing.JLabel jLabel_plot_Marker_Color;
    private javax.swing.JLabel jLabel_plot_Marker_FillColor;
    private javax.swing.JLabel jLabel_plot_Marker_On;
    private javax.swing.JLabel jLabel_plot_Marker_Size;
    private javax.swing.JLabel jLabel_plot_Marker_Style;
    private javax.swing.JLabel jLabel_plot_Marker_Thickness;
    private javax.swing.JLabel jLabel_plot_Marker_Type;
    private javax.swing.JLabel jLabel_plot_Title_Color;
    private javax.swing.JLabel jLabel_plot_Title_Font;
    private javax.swing.JLabel jLabel_plot_Title_FontSize;
    private javax.swing.JLabel jLabel_plot_Title_Text;
    private javax.swing.JLabel jLabel_plot_Title_xAlign;
    private javax.swing.JLabel jLabel_plot_Title_yAlign;
    private javax.swing.JLabel jLabel_xAxis_Auto;
    private javax.swing.JLabel jLabel_xAxis_Grid_Color;
    private javax.swing.JLabel jLabel_xAxis_Grid_On;
    private javax.swing.JLabel jLabel_xAxis_Grid_Size;
    private javax.swing.JLabel jLabel_xAxis_Grid_Spacing;
    private javax.swing.JLabel jLabel_xAxis_Grid_Style;
    private javax.swing.JLabel jLabel_xAxis_Label_Color;
    private javax.swing.JLabel jLabel_xAxis_Label_Font;
    private javax.swing.JLabel jLabel_xAxis_Label_FontSize;
    private javax.swing.JLabel jLabel_xAxis_Label_Text;
    private javax.swing.JLabel jLabel_xAxis_Label_xAlign;
    private javax.swing.JLabel jLabel_xAxis_Label_yAlign;
    private javax.swing.JLabel jLabel_xAxis_Line_Color;
    private javax.swing.JLabel jLabel_xAxis_Line_Size;
    private javax.swing.JLabel jLabel_xAxis_Line_Style;
    private javax.swing.JLabel jLabel_xAxis_Max;
    private javax.swing.JLabel jLabel_xAxis_Min;
    private javax.swing.JLabel jLabel_xAxis_TickLabel_Color;
    private javax.swing.JLabel jLabel_xAxis_TickLabel_Font;
    private javax.swing.JLabel jLabel_xAxis_TickLabel_FontSize;
    private javax.swing.JLabel jLabel_xAxis_TickLabel_On;
    private javax.swing.JLabel jLabel_xAxis_TickLabel_Spacing;
    private javax.swing.JLabel jLabel_xAxis_TickLabel_xAlign;
    private javax.swing.JLabel jLabel_xAxis_TickLabel_yAlign;
    private javax.swing.JLabel jLabel_xAxis_TickMarks_Color;
    private javax.swing.JLabel jLabel_xAxis_TickMarks_Length;
    private javax.swing.JLabel jLabel_xAxis_TickMarks_On;
    private javax.swing.JLabel jLabel_xAxis_TickMarks_Size;
    private javax.swing.JLabel jLabel_xAxis_TickMarks_Spacing;
    private javax.swing.JLabel jLabel_yAxis_Auto;
    private javax.swing.JLabel jLabel_yAxis_Grid_Color;
    private javax.swing.JLabel jLabel_yAxis_Grid_On;
    private javax.swing.JLabel jLabel_yAxis_Grid_Size;
    private javax.swing.JLabel jLabel_yAxis_Grid_Style;
    private javax.swing.JLabel jLabel_yAxis_Label_Color;
    private javax.swing.JLabel jLabel_yAxis_Label_Font;
    private javax.swing.JLabel jLabel_yAxis_Label_FontSize;
    private javax.swing.JLabel jLabel_yAxis_Label_Text;
    private javax.swing.JLabel jLabel_yAxis_Label_xAlign;
    private javax.swing.JLabel jLabel_yAxis_Label_yAlign;
    private javax.swing.JLabel jLabel_yAxis_Line_Color;
    private javax.swing.JLabel jLabel_yAxis_Line_Size;
    private javax.swing.JLabel jLabel_yAxis_Line_Style;
    private javax.swing.JLabel jLabel_yAxis_Max;
    private javax.swing.JLabel jLabel_yAxis_Min;
    private javax.swing.JLabel jLabel_yAxis_TickLabel_Color;
    private javax.swing.JLabel jLabel_yAxis_TickLabel_Font;
    private javax.swing.JLabel jLabel_yAxis_TickLabel_FontSize;
    private javax.swing.JLabel jLabel_yAxis_TickLabel_On;
    private javax.swing.JLabel jLabel_yAxis_TickLabel_Spacing;
    private javax.swing.JLabel jLabel_yAxis_TickLabel_xAlign;
    private javax.swing.JLabel jLabel_yAxis_TickLabel_yAlign;
    private javax.swing.JLabel jLabel_yAxis_TickMarks_Color;
    private javax.swing.JLabel jLabel_yAxis_TickMarks_Length;
    private javax.swing.JLabel jLabel_yAxis_TickMarks_On;
    private javax.swing.JLabel jLabel_yAxis_TickMarks_Size;
    private javax.swing.JLabel jLabel_yAxis_TickMarks_Spacing;
    private javax.swing.JPanel jPanel_Buttons;
    private javax.swing.JPanel jPanel_Heading;
    private javax.swing.JPanel jPanel_Plot;
    private javax.swing.JPanel jPanel_plot_Background_Color;
    private javax.swing.JPanel jPanel_plot_Box;
    private javax.swing.JPanel jPanel_plot_Box_Color;
    private javax.swing.JPanel jPanel_plot_Box_FillColor;
    private javax.swing.JPanel jPanel_plot_Line;
    private javax.swing.JPanel jPanel_plot_Line_Color;
    private javax.swing.JPanel jPanel_plot_Marker;
    private javax.swing.JPanel jPanel_plot_Marker_Color;
    private javax.swing.JPanel jPanel_plot_Marker_FillColor;
    private javax.swing.JPanel jPanel_plot_Title;
    private javax.swing.JPanel jPanel_plot_Title_Color;
    private javax.swing.JPanel jPanel_xAxis;
    private javax.swing.JPanel jPanel_xAxis_Axis;
    private javax.swing.JPanel jPanel_xAxis_Grid;
    private javax.swing.JPanel jPanel_xAxis_Grid_Color;
    private javax.swing.JPanel jPanel_xAxis_Label;
    private javax.swing.JPanel jPanel_xAxis_Label_Color;
    private javax.swing.JPanel jPanel_xAxis_Line;
    private javax.swing.JPanel jPanel_xAxis_Line_Color;
    private javax.swing.JPanel jPanel_xAxis_TickLabel;
    private javax.swing.JPanel jPanel_xAxis_TickLabel_Color;
    private javax.swing.JPanel jPanel_xAxis_TickMarks;
    private javax.swing.JPanel jPanel_xAxis_TickMarks_Color;
    private javax.swing.JPanel jPanel_yAxis1;
    private javax.swing.JPanel jPanel_yAxis_Axis;
    private javax.swing.JPanel jPanel_yAxis_Grid;
    private javax.swing.JPanel jPanel_yAxis_Grid_Color;
    private javax.swing.JPanel jPanel_yAxis_Label;
    private javax.swing.JPanel jPanel_yAxis_Label_Color;
    private javax.swing.JPanel jPanel_yAxis_Line;
    private javax.swing.JPanel jPanel_yAxis_Line_Color;
    private javax.swing.JPanel jPanel_yAxis_TickLabel;
    private javax.swing.JPanel jPanel_yAxis_TickLabel_Color;
    private javax.swing.JPanel jPanel_yAxis_TickMarks;
    private javax.swing.JPanel jPanel_yAxis_TickMarks_Color;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextField_plot_Box_Padding1;
    private javax.swing.JTextField jTextField_plot_Box_Padding2;
    private javax.swing.JTextField jTextField_plot_Box_Padding3;
    private javax.swing.JTextField jTextField_plot_Box_Padding4;
    private javax.swing.JTextField jTextField_plot_Box_Size;
    private javax.swing.JTextField jTextField_plot_Box_Style1;
    private javax.swing.JTextField jTextField_plot_Box_Style2;
    private javax.swing.JTextField jTextField_plot_Box_Style3;
    private javax.swing.JTextField jTextField_plot_Box_Style4;
    private javax.swing.JTextField jTextField_plot_Line_Size;
    private javax.swing.JTextField jTextField_plot_Line_Style1;
    private javax.swing.JTextField jTextField_plot_Line_Style2;
    private javax.swing.JTextField jTextField_plot_Line_Style3;
    private javax.swing.JTextField jTextField_plot_Line_Style4;
    private javax.swing.JTextField jTextField_plot_Marker_Size;
    private javax.swing.JTextField jTextField_plot_Marker_Style1;
    private javax.swing.JTextField jTextField_plot_Marker_Style2;
    private javax.swing.JTextField jTextField_plot_Marker_Thickness;
    private javax.swing.JTextField jTextField_plot_Title_FontSize;
    private javax.swing.JTextField jTextField_plot_Title_Text;
    private javax.swing.JTextField jTextField_plot_Title_xAlign;
    private javax.swing.JTextField jTextField_plot_Title_yAlign;
    private javax.swing.JTextField jTextField_xAxis_Grid_Size;
    private javax.swing.JTextField jTextField_xAxis_Grid_Spacing;
    private javax.swing.JTextField jTextField_xAxis_Grid_Style1;
    private javax.swing.JTextField jTextField_xAxis_Grid_Style2;
    private javax.swing.JTextField jTextField_xAxis_Grid_Style3;
    private javax.swing.JTextField jTextField_xAxis_Grid_Style4;
    private javax.swing.JTextField jTextField_xAxis_Label_FontSize;
    private javax.swing.JTextField jTextField_xAxis_Label_Text;
    private javax.swing.JTextField jTextField_xAxis_Label_xAlign;
    private javax.swing.JTextField jTextField_xAxis_Label_yAlign;
    private javax.swing.JTextField jTextField_xAxis_Line_Size;
    private javax.swing.JTextField jTextField_xAxis_Line_Style1;
    private javax.swing.JTextField jTextField_xAxis_Line_Style2;
    private javax.swing.JTextField jTextField_xAxis_Line_Style3;
    private javax.swing.JTextField jTextField_xAxis_Line_Style4;
    private javax.swing.JTextField jTextField_xAxis_Max;
    private javax.swing.JTextField jTextField_xAxis_Min;
    private javax.swing.JTextField jTextField_xAxis_TickLabel_FontSize;
    private javax.swing.JTextField jTextField_xAxis_TickLabel_Spacing;
    private javax.swing.JTextField jTextField_xAxis_TickLabel_xAlign;
    private javax.swing.JTextField jTextField_xAxis_TickLabel_yAlign;
    private javax.swing.JTextField jTextField_xAxis_TickMarks_Length;
    private javax.swing.JTextField jTextField_xAxis_TickMarks_Size;
    private javax.swing.JTextField jTextField_xAxis_TickMarks_Spacing;
    private javax.swing.JTextField jTextField_yAxis_Grid_Size;
    private javax.swing.JTextField jTextField_yAxis_Grid_Spacing;
    private javax.swing.JTextField jTextField_yAxis_Grid_Style1;
    private javax.swing.JTextField jTextField_yAxis_Grid_Style2;
    private javax.swing.JTextField jTextField_yAxis_Grid_Style3;
    private javax.swing.JTextField jTextField_yAxis_Grid_Style4;
    private javax.swing.JTextField jTextField_yAxis_Label_FontSize;
    private javax.swing.JTextField jTextField_yAxis_Label_Text;
    private javax.swing.JTextField jTextField_yAxis_Label_xAlign;
    private javax.swing.JTextField jTextField_yAxis_Label_yAlign;
    private javax.swing.JTextField jTextField_yAxis_Line_Size;
    private javax.swing.JTextField jTextField_yAxis_Line_Style1;
    private javax.swing.JTextField jTextField_yAxis_Line_Style2;
    private javax.swing.JTextField jTextField_yAxis_Line_Style3;
    private javax.swing.JTextField jTextField_yAxis_Line_Style4;
    private javax.swing.JTextField jTextField_yAxis_Max;
    private javax.swing.JTextField jTextField_yAxis_Min;
    private javax.swing.JTextField jTextField_yAxis_TickLabel_FontSize;
    private javax.swing.JTextField jTextField_yAxis_TickLabel_Spacing;
    private javax.swing.JTextField jTextField_yAxis_TickLabel_xAlign;
    private javax.swing.JTextField jTextField_yAxis_TickLabel_yAlign;
    private javax.swing.JTextField jTextField_yAxis_TickMarks_Length;
    private javax.swing.JTextField jTextField_yAxis_TickMarks_Size;
    private javax.swing.JTextField jTextField_yAxis_TickMarks_Spacing;
    // End of variables declaration//GEN-END:variables
}
