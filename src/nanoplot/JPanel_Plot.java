/**
 * @author
 *------------------------------------------------------------------------------
 * File Name:      <JPanelGridPattern.java>
 * Author:         Amit M. Manthanwar
 * Email:          amit@imperial.ac.uk
 * Copyright:      2009 Amit M. Manthanwar
 * License:        Restricted
 *
 *---------------+---------+----------------------------------------------------
 * Revision Log  | Author  | Description
 *---------------+---------+----------------------------------------------------
 * 29 Jul, 2008  | AMM     | Initial version Created with JDK 1.6.0_05
 *---------------+---------+----------------------------------------------------
 *
 *---------------+---------+----------------------------------------------------
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanel_Plot.java
 *
 * Created on 10 Apr, 2009, 3:30:49 AM
 */
package nanoplot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Amit
 */
public class JPanel_Plot extends JPanel {

    public JPanel_Plot() {

        jd_Plot_Settings = new JDialog_Plot_Settings(this);

        setDefaultValues();
        mouseListener();


    }

    private void mouseListener() {

        this.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                if (evt.getClickCount() == 2) {
                    setCurrentValues();
                    jd_Plot_Settings.setVisible(true);
                }
            }
        });
    }

    public void setSettingsVisible(boolean isVisible) {
        if (isVisible) {
            setCurrentValues();
            jd_Plot_Settings.setVisible(true);
        }
        else {
            jd_Plot_Settings.setVisible(false);
            jd_Plot_Settings.dispose();
        }
    }

    //Default Settings
    public void setDefaultValues() {

        plot_Line_Type = "Line";

        //Plot
        plot_Title_Text = "";
        plot_Title_Color = Color.BLACK;
        plot_Title_Font = "Tahoma Bold";
        plot_Title_FontSize = 14;
        plot_Title_xAlign = 10;
        plot_Title_yAlign = 10;

        //Plot Line
        plot_Line_Size = 1.5f;
        plot_Line_Color = Color.BLUE;
        plot_Background_Color = new Color(240, 240, 240); //system default gray
        plot_Line_Style1 = 2.0f;
        plot_Line_Style2 = 0;
        plot_Line_Style3 = 0;
        plot_Line_Style4 = 0;

        //Plot Maker
        plot_Marker_On = false;
        plot_Marker_Type = "Circle";
        plot_Marker_Size = 10;
        plot_Marker_Color = Color.RED;
        plot_Marker_FillColor = Color.GREEN;
        plot_Marker_Style1 = 2.0f;
        plot_Marker_Style2 = 0;
        plot_Marker_Thickness = 2.0f;
//        plot_Marker_Style3 = 0;
//        plot_Marker_Style4 = 0;

        //Plot Box
        plot_Box_Padding1 = 40;//West
        plot_Box_Padding2 = 10;//North
        plot_Box_Padding3 = 20;//East
        plot_Box_Padding4 = 20;//South
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
//        xAxis_Min = 0.0f;
//        xAxis_Max = 100.0f;

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
        xAxis_Grid_Style1 = 2.0f;
        xAxis_Grid_Style2 = 4.0f;
        xAxis_Grid_Style3 = 2.0f;
        xAxis_Grid_Style4 = 4.0f;

        //xAxis TickMarks
        xAxis_TickMarks_On = false;
        xAxis_TickMarks_Size = 1;
        xAxis_TickMarks_Spacing = 10.0f;
        xAxis_TickMarks_Length = 5;
        xAxis_TickMarks_Color = Color.BLACK;

        //xAxis TickLabel
        xAxis_TickLabel_On = true;
        xAxis_TickLabel_Font = "Tahoma";
        xAxis_TickLabel_FontSize = 10;
        xAxis_TickLabel_Color = Color.BLACK;
        xAxis_TickLabel_xAlign = 0;
        xAxis_TickLabel_yAlign = 0;
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
        //yAxis_Min = 0.0f;
        // yAxis_Max = 100.0f;


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
        yAxis_Grid_Style1 = 2.0f;
        yAxis_Grid_Style2 = 4.0f;
        yAxis_Grid_Style3 = 2.0f;
        yAxis_Grid_Style4 = 4.0f;

        //yAxis TickMarks
        yAxis_TickMarks_On = false;
        yAxis_TickMarks_Size = 1;
        yAxis_TickMarks_Spacing = 10.0f;
        yAxis_TickMarks_Length = 5.0f;
        yAxis_TickMarks_Color = Color.BLACK;

        //yAxis TickLabel
        yAxis_TickLabel_On = true;
        yAxis_TickLabel_Font = "Tahoma";
        yAxis_TickLabel_FontSize = 10;
        yAxis_TickLabel_Color = Color.BLACK;
        yAxis_TickLabel_xAlign = 0;
        yAxis_TickLabel_yAlign = 0;
        yAxis_TickLabel_Spacing = 10.0f;
    }

    //Send current Vales to Settings Dialog Box
    private void setCurrentValues() {

        //Get Default Values
        //jd_Plot_Settings.setDefaultValues();

        //Plot
        jd_Plot_Settings.setPlot_Title_Text(plot_Title_Text);
        jd_Plot_Settings.setPlot_Title_Color(plot_Title_Color);
        jd_Plot_Settings.setPlot_Title_Font(plot_Title_Font);
        jd_Plot_Settings.setPlot_Title_FontSize(plot_Title_FontSize);
        jd_Plot_Settings.setPlot_Title_xAlign(plot_Title_xAlign);
        jd_Plot_Settings.setPlot_Title_yAlign(plot_Title_yAlign);

        //Plot Line
        jd_Plot_Settings.setPlot_Line_Size(plot_Line_Size);
        jd_Plot_Settings.setPlot_Line_Type(plot_Line_Type);
        jd_Plot_Settings.setPlot_Line_Color(plot_Line_Color);
        jd_Plot_Settings.setPlot_Background_Color(plot_Background_Color);
        jd_Plot_Settings.setPlot_Line_Style1(plot_Line_Style1);
        jd_Plot_Settings.setPlot_Line_Style2(plot_Line_Style2);
        jd_Plot_Settings.setPlot_Line_Style3(plot_Line_Style3);
        jd_Plot_Settings.setPlot_Line_Style4(plot_Line_Style4);

        //Plot Maker
        jd_Plot_Settings.setPlot_Marker_On(plot_Marker_On);
        jd_Plot_Settings.setPlot_Marker_Size(plot_Marker_Size);
        jd_Plot_Settings.setPlot_Marker_Type(plot_Marker_Type);
        jd_Plot_Settings.setPlot_Marker_Color(plot_Marker_Color);
        jd_Plot_Settings.setPlot_Marker_FillColor(plot_Marker_FillColor);
        jd_Plot_Settings.setPlot_Marker_Style1(plot_Marker_Style1);
        jd_Plot_Settings.setPlot_Marker_Style2(plot_Marker_Style2);
        jd_Plot_Settings.setPlot_Marker_Thickness(plot_Marker_Thickness);
//        jd_Plot_Settings.setPlot_Marker_Style3(plot_Marker_Style3);
//        jd_Plot_Settings.setPlot_Marker_Style4(plot_Marker_Style4);

        //Plot Box
        jd_Plot_Settings.setPlot_Box_Padding1(plot_Box_Padding1);
        jd_Plot_Settings.setPlot_Box_Padding2(plot_Box_Padding2);
        jd_Plot_Settings.setPlot_Box_Padding3(plot_Box_Padding3);
        jd_Plot_Settings.setPlot_Box_Padding4(plot_Box_Padding4);
        jd_Plot_Settings.setPlot_Box_On(plot_Box_On);
        jd_Plot_Settings.setPlot_Box_Size(plot_Box_Size);
        jd_Plot_Settings.setPlot_Box_Color(plot_Box_Color);
        jd_Plot_Settings.setPlot_Box_FillColor(plot_Box_FillColor);
        jd_Plot_Settings.setPlot_Box_Style1(plot_Box_Style1);
        jd_Plot_Settings.setPlot_Box_Style2(plot_Box_Style2);
        jd_Plot_Settings.setPlot_Box_Style3(plot_Box_Style3);
        jd_Plot_Settings.setPlot_Box_Style4(plot_Box_Style4);


        //xLabel
        jd_Plot_Settings.setXAxis_Label_Text(xAxis_Label_Text);
        jd_Plot_Settings.setXAxis_Label_Color(xAxis_Label_Color);
        jd_Plot_Settings.setXAxis_Label_Font(xAxis_Label_Font);
        jd_Plot_Settings.setXAxis_Label_FontSize(xAxis_Label_FontSize);
        jd_Plot_Settings.setXAxis_Label_xAlign(xAxis_Label_xAlign);
        jd_Plot_Settings.setXAxis_Label_yAlign(xAxis_Label_yAlign);

        //xAxis Limit
        jd_Plot_Settings.setXAxis_Auto(xAxis_Auto);
        jd_Plot_Settings.setXAxis_Min(xAxis_Min);
        jd_Plot_Settings.setXAxis_Max(xAxis_Max);

        //xAxis Line
        jd_Plot_Settings.setXAxis_Line_Size(xAxis_Line_Size);
        jd_Plot_Settings.setXAxis_Line_Color(xAxis_Line_Color);
        jd_Plot_Settings.setXAxis_Line_Style1(xAxis_Line_Style1);
        jd_Plot_Settings.setXAxis_Line_Style2(xAxis_Line_Style2);
        jd_Plot_Settings.setXAxis_Line_Style3(xAxis_Line_Style3);
        jd_Plot_Settings.setXAxis_Line_Style4(xAxis_Line_Style4);

        //xAxis Grid
        jd_Plot_Settings.setXAxis_Grid_On(xAxis_Grid_On);
        jd_Plot_Settings.setXAxis_Grid_Color(xAxis_Grid_Color);
        jd_Plot_Settings.setXAxis_Grid_Size(xAxis_Grid_Size);
        jd_Plot_Settings.setXAxis_Grid_Size(xAxis_Grid_Spacing);
        jd_Plot_Settings.setXAxis_Grid_Style1(xAxis_Grid_Style1);
        jd_Plot_Settings.setXAxis_Grid_Style2(xAxis_Grid_Style2);
        jd_Plot_Settings.setXAxis_Grid_Style3(xAxis_Grid_Style3);
        jd_Plot_Settings.setXAxis_Grid_Style4(xAxis_Grid_Style4);

        //xAxis TickMarks
        jd_Plot_Settings.setXAxis_TickMarks_On(xAxis_TickMarks_On);
        jd_Plot_Settings.setXAxis_TickMarks_Size(xAxis_TickMarks_Size);
        jd_Plot_Settings.setXAxis_TickMarks_Spacing(xAxis_TickMarks_Spacing);
        jd_Plot_Settings.setXAxis_TickMarks_Spacing(xAxis_TickMarks_Length);
        jd_Plot_Settings.setXAxis_TickMarks_Color(xAxis_TickMarks_Color);

        //xAxis TickLabel
        jd_Plot_Settings.setXAxis_TickLabel_On(xAxis_TickLabel_On);
        jd_Plot_Settings.setXAxis_TickLabel_Font(xAxis_TickLabel_Font);
        jd_Plot_Settings.setXAxis_TickLabel_FontSize(xAxis_TickLabel_FontSize);
        jd_Plot_Settings.setXAxis_TickLabel_Color(xAxis_TickLabel_Color);
        jd_Plot_Settings.setXAxis_TickLabel_xAlign(xAxis_TickLabel_xAlign);
        jd_Plot_Settings.setXAxis_TickLabel_yAlign(xAxis_TickLabel_yAlign);
        jd_Plot_Settings.setXAxis_TickLabel_Spacing(xAxis_TickLabel_Spacing);


        //xLabel
        jd_Plot_Settings.setYAxis_Label_Text(yAxis_Label_Text);
        jd_Plot_Settings.setYAxis_Label_Color(yAxis_Label_Color);
        jd_Plot_Settings.setYAxis_Label_Font(yAxis_Label_Font);
        jd_Plot_Settings.setYAxis_Label_FontSize(yAxis_Label_FontSize);
        jd_Plot_Settings.setYAxis_Label_xAlign(yAxis_Label_xAlign);
        jd_Plot_Settings.setYAxis_Label_yAlign(yAxis_Label_yAlign);

        //yAxis Limit
        jd_Plot_Settings.setYAxis_Auto(yAxis_Auto);
        jd_Plot_Settings.setYAxis_Min(yAxis_Min);
        jd_Plot_Settings.setYAxis_Max(yAxis_Max);

        //yAxis Line
        jd_Plot_Settings.setYAxis_Line_Size(yAxis_Line_Size);
        jd_Plot_Settings.setYAxis_Line_Color(yAxis_Line_Color);
        jd_Plot_Settings.setYAxis_Line_Style1(yAxis_Line_Style1);
        jd_Plot_Settings.setYAxis_Line_Style2(yAxis_Line_Style2);
        jd_Plot_Settings.setYAxis_Line_Style3(yAxis_Line_Style3);
        jd_Plot_Settings.setYAxis_Line_Style4(yAxis_Line_Style4);

        //yAxis Grid
        jd_Plot_Settings.setYAxis_Grid_On(yAxis_Grid_On);
        jd_Plot_Settings.setYAxis_Grid_Color(yAxis_Grid_Color);
        jd_Plot_Settings.setYAxis_Grid_Size(yAxis_Grid_Size);
        jd_Plot_Settings.setYAxis_Grid_Size(yAxis_Grid_Spacing);
        jd_Plot_Settings.setYAxis_Grid_Style1(yAxis_Grid_Style1);
        jd_Plot_Settings.setYAxis_Grid_Style2(yAxis_Grid_Style2);
        jd_Plot_Settings.setYAxis_Grid_Style3(yAxis_Grid_Style3);
        jd_Plot_Settings.setYAxis_Grid_Style4(yAxis_Grid_Style4);

        //yAxis TickMarks
        jd_Plot_Settings.setYAxis_TickMarks_On(yAxis_TickMarks_On);
        jd_Plot_Settings.setYAxis_TickMarks_Size(yAxis_TickMarks_Size);
        jd_Plot_Settings.setYAxis_TickMarks_Spacing(yAxis_TickMarks_Spacing);
        jd_Plot_Settings.setYAxis_TickMarks_Length(yAxis_TickMarks_Length);
        jd_Plot_Settings.setYAxis_TickMarks_Color(yAxis_TickMarks_Color);

        //yAxis TickLabel
        jd_Plot_Settings.setYAxis_TickLabel_On(yAxis_TickLabel_On);
        jd_Plot_Settings.setYAxis_TickLabel_Font(yAxis_TickLabel_Font);
        jd_Plot_Settings.setYAxis_TickLabel_FontSize(yAxis_TickLabel_FontSize);
        jd_Plot_Settings.setYAxis_TickLabel_Color(yAxis_TickLabel_Color);
        jd_Plot_Settings.setYAxis_TickLabel_xAlign(yAxis_TickLabel_xAlign);
        jd_Plot_Settings.setYAxis_TickLabel_yAlign(yAxis_TickLabel_yAlign);
        jd_Plot_Settings.setYAxis_TickLabel_Spacing(yAxis_TickLabel_Spacing);

        jd_Plot_Settings.setSettings();

    }

    //Set new Vales from Settings Dialog Box
    public void setNewValues() {

        //Plot
        plot_Title_Text = jd_Plot_Settings.getPlot_Title_Text();
        plot_Title_Color = jd_Plot_Settings.getPlot_Title_Color();
        plot_Title_Font = jd_Plot_Settings.getPlot_Title_Font();
        plot_Title_FontSize = jd_Plot_Settings.getPlot_Title_FontSize();
        plot_Title_xAlign = jd_Plot_Settings.getPlot_Title_xAlign();
        plot_Title_yAlign = jd_Plot_Settings.getPlot_Title_yAlign();

        //Plot Line
        plot_Line_Size = jd_Plot_Settings.getPlot_Line_Size();
        plot_Line_Type = jd_Plot_Settings.getPlot_Line_Type();
        plot_Line_Color = jd_Plot_Settings.getPlot_Line_Color();
        plot_Background_Color = jd_Plot_Settings.getPlot_Background_Color();
        plot_Line_Style1 = jd_Plot_Settings.getPlot_Line_Style1();
        plot_Line_Style2 = jd_Plot_Settings.getPlot_Line_Style2();
        plot_Line_Style3 = jd_Plot_Settings.getPlot_Line_Style3();
        plot_Line_Style4 = jd_Plot_Settings.getPlot_Line_Style4();

        //Plot Maker
        plot_Marker_On = jd_Plot_Settings.getPlot_Marker_On();
        plot_Marker_Size = jd_Plot_Settings.getPlot_Marker_Size();
        plot_Marker_Type = jd_Plot_Settings.getPlot_Marker_Type();
        plot_Marker_Color = jd_Plot_Settings.getPlot_Marker_Color();
        plot_Marker_FillColor = jd_Plot_Settings.getPlot_Marker_FillColor();
        plot_Marker_Style1 = jd_Plot_Settings.getPlot_Marker_Style1();
        plot_Marker_Style2 = jd_Plot_Settings.getPlot_Marker_Style2();
        plot_Marker_Thickness = jd_Plot_Settings.getPlot_Marker_Thickness();
//        plot_Marker_Style3 = jd_Plot_Settings.getPlot_Marker_Style3();
//        plot_Marker_Style4 = jd_Plot_Settings.getPlot_Marker_Style4();

        //Plot Box
        plot_Box_Padding1 = jd_Plot_Settings.getPlot_Box_Padding1();
        plot_Box_Padding2 = jd_Plot_Settings.getPlot_Box_Padding2();
        plot_Box_Padding3 = jd_Plot_Settings.getPlot_Box_Padding3();
        plot_Box_Padding4 = jd_Plot_Settings.getPlot_Box_Padding4();
        plot_Box_On = jd_Plot_Settings.getPlot_Box_On();
        plot_Box_Size = jd_Plot_Settings.getPlot_Box_Size();
        plot_Box_Color = jd_Plot_Settings.getPlot_Box_Color();
        plot_Box_FillColor = jd_Plot_Settings.getPlot_Box_FillColor();
        plot_Box_Style1 = jd_Plot_Settings.getPlot_Box_Style1();
        plot_Box_Style2 = jd_Plot_Settings.getPlot_Box_Style2();
        plot_Box_Style3 = jd_Plot_Settings.getPlot_Box_Style3();
        plot_Box_Style4 = jd_Plot_Settings.getPlot_Box_Style4();


        //xAxis Label
        xAxis_Label_Text = jd_Plot_Settings.getXAxis_Label_Text();
        xAxis_Label_Color = jd_Plot_Settings.getXAxis_Label_Color();
        xAxis_Label_Font = jd_Plot_Settings.getXAxis_Label_Font();
        xAxis_Label_FontSize = jd_Plot_Settings.getXAxis_Label_FontSize();
        xAxis_Label_xAlign = jd_Plot_Settings.getXAxis_Label_xAlign();
        xAxis_Label_yAlign = jd_Plot_Settings.getXAxis_Label_yAlign();

        //xAxis Limit
        xAxis_Auto = jd_Plot_Settings.getXAxis_Auto();
        xAxis_Min = jd_Plot_Settings.getXAxis_Min();
        xAxis_Max = jd_Plot_Settings.getXAxis_Max();

        //xAxis Line
        xAxis_Line_Size = jd_Plot_Settings.getXAxis_Line_Size();
        xAxis_Line_Color = jd_Plot_Settings.getXAxis_Line_Color();
        xAxis_Line_Style1 = jd_Plot_Settings.getXAxis_Line_Style1();
        xAxis_Line_Style2 = jd_Plot_Settings.getXAxis_Line_Style2();
        xAxis_Line_Style3 = jd_Plot_Settings.getXAxis_Line_Style3();
        xAxis_Line_Style4 = jd_Plot_Settings.getXAxis_Line_Style4();

        //xAxis Grid
        xAxis_Grid_On = jd_Plot_Settings.getXAxis_Grid_On();
        xAxis_Grid_Color = jd_Plot_Settings.getXAxis_Grid_Color();
        xAxis_Grid_Size = jd_Plot_Settings.getXAxis_Grid_Size();
        xAxis_Grid_Spacing = jd_Plot_Settings.getXAxis_Grid_Spacing();
        xAxis_Grid_Style1 = jd_Plot_Settings.getXAxis_Grid_Style1();
        xAxis_Grid_Style2 = jd_Plot_Settings.getXAxis_Grid_Style2();
        xAxis_Grid_Style3 = jd_Plot_Settings.getXAxis_Grid_Style3();
        xAxis_Grid_Style4 = jd_Plot_Settings.getXAxis_Grid_Style4();

        //xAxis TickMarks
        xAxis_TickMarks_On = jd_Plot_Settings.getXAxis_TickMarks_On();
        xAxis_TickMarks_Size = jd_Plot_Settings.getXAxis_TickMarks_Size();
        xAxis_TickMarks_Spacing = jd_Plot_Settings.getXAxis_TickMarks_Spacing();
        xAxis_TickMarks_Length = jd_Plot_Settings.getXAxis_TickMarks_Length();
        xAxis_TickMarks_Color = jd_Plot_Settings.getXAxis_TickMarks_Color();

        //xAxis TickLabel
        xAxis_TickLabel_On = jd_Plot_Settings.getXAxis_TickLabel_On();
        xAxis_TickLabel_Font = jd_Plot_Settings.getXAxis_TickLabel_Font();
        xAxis_TickLabel_FontSize = jd_Plot_Settings.getXAxis_TickLabel_FontSize();
        xAxis_TickLabel_Color = jd_Plot_Settings.getXAxis_TickLabel_Color();

        xAxis_TickLabel_xAlign = jd_Plot_Settings.getXAxis_TickLabel_xAlign();
        xAxis_TickLabel_yAlign = jd_Plot_Settings.getXAxis_TickLabel_yAlign();
        xAxis_TickLabel_Spacing = jd_Plot_Settings.getXAxis_TickLabel_Spacing();

        //yAxis Label
        yAxis_Label_Text = jd_Plot_Settings.getYAxis_Label_Text();
        yAxis_Label_Color = jd_Plot_Settings.getYAxis_Label_Color();
        yAxis_Label_Font = jd_Plot_Settings.getYAxis_Label_Font();
        yAxis_Label_FontSize = jd_Plot_Settings.getYAxis_Label_FontSize();
        yAxis_Label_xAlign = jd_Plot_Settings.getYAxis_Label_xAlign();
        yAxis_Label_yAlign = jd_Plot_Settings.getYAxis_Label_yAlign();

        //yAxis Limit
        yAxis_Auto = jd_Plot_Settings.getYAxis_Auto();
        yAxis_Min = jd_Plot_Settings.getYAxis_Min();
        yAxis_Max = jd_Plot_Settings.getYAxis_Max();

        //yAxis Line
        yAxis_Line_Size = jd_Plot_Settings.getYAxis_Line_Size();
        yAxis_Line_Color = jd_Plot_Settings.getYAxis_Line_Color();
        yAxis_Line_Style1 = jd_Plot_Settings.getYAxis_Line_Style1();
        yAxis_Line_Style2 = jd_Plot_Settings.getYAxis_Line_Style2();
        yAxis_Line_Style3 = jd_Plot_Settings.getYAxis_Line_Style3();
        yAxis_Line_Style4 = jd_Plot_Settings.getYAxis_Line_Style4();

        //yAxis Grid
        yAxis_Grid_On = jd_Plot_Settings.getYAxis_Grid_On();
        yAxis_Grid_Color = jd_Plot_Settings.getYAxis_Grid_Color();
        yAxis_Grid_Size = jd_Plot_Settings.getYAxis_Grid_Size();
        yAxis_Grid_Spacing = jd_Plot_Settings.getYAxis_Grid_Spacing();
        yAxis_Grid_Style1 = jd_Plot_Settings.getYAxis_Grid_Style1();
        yAxis_Grid_Style2 = jd_Plot_Settings.getYAxis_Grid_Style2();
        yAxis_Grid_Style3 = jd_Plot_Settings.getYAxis_Grid_Style3();
        yAxis_Grid_Style4 = jd_Plot_Settings.getYAxis_Grid_Style4();

        //yAxis TickMarks
        yAxis_TickMarks_On = jd_Plot_Settings.getYAxis_TickMarks_On();
        yAxis_TickMarks_Size = jd_Plot_Settings.getYAxis_TickMarks_Size();
        yAxis_TickMarks_Spacing = jd_Plot_Settings.getYAxis_TickMarks_Spacing();
        yAxis_TickMarks_Length = jd_Plot_Settings.getYAxis_TickMarks_Length();
        yAxis_TickMarks_Color = jd_Plot_Settings.getYAxis_TickMarks_Color();

        //yAxis TickLabel
        yAxis_TickLabel_On = jd_Plot_Settings.getYAxis_TickLabel_On();
        yAxis_TickLabel_Font = jd_Plot_Settings.getYAxis_TickLabel_Font();
        yAxis_TickLabel_FontSize = jd_Plot_Settings.getYAxis_TickLabel_FontSize();
        yAxis_TickLabel_Color = jd_Plot_Settings.getYAxis_TickLabel_Color();
        yAxis_TickLabel_xAlign = jd_Plot_Settings.getYAxis_TickLabel_xAlign();
        yAxis_TickLabel_yAlign = jd_Plot_Settings.getYAxis_TickLabel_yAlign();
        yAxis_TickLabel_Spacing = jd_Plot_Settings.getYAxis_TickLabel_Spacing();


    }

    protected void drawAxes(Graphics g) {
        //Plot xy Axis
        Graphics2D line2dAxes = (Graphics2D) g;

        //Draw Box
        if (plot_Box_On) {
            float[] plot_Box_Style = {plot_Box_Style1, plot_Box_Style2, plot_Box_Style3, plot_Box_Style4};
            BasicStroke g2dAxesStroke = new BasicStroke(plot_Box_Size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, plot_Box_Style, 0);
            line2dAxes.setStroke(g2dAxesStroke);

            //Draw Rectangle Box 2D
            Rectangle2D box = new Rectangle2D.Float(plot_Box_Padding1, plot_Box_Padding2, width - plot_Box_Padding1 - plot_Box_Padding3, height - plot_Box_Padding2 - plot_Box_Padding4);
            line2dAxes.setPaint(plot_Box_FillColor);
            line2dAxes.fill(box);
            line2dAxes.setPaint(plot_Box_Color);
            line2dAxes.draw(box);
        }
        else {
            // abcissa - x Axis
            float[] xAxis_Line_Style = {xAxis_Line_Style1, xAxis_Line_Style2, xAxis_Line_Style3, xAxis_Line_Style4};
            BasicStroke g2dAxesStroke = new BasicStroke(xAxis_Line_Size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, xAxis_Line_Style, 0);
            line2dAxes.setStroke(g2dAxesStroke);
            line2dAxes.setColor(xAxis_Line_Color);
            line2dAxes.draw(new Line2D.Float(plot_Box_Padding1, height - plot_Box_Padding4, width - plot_Box_Padding3, height - plot_Box_Padding4));

            // ordinate - y Axis
            float[] yAxis_Line_Style = {yAxis_Line_Style1, yAxis_Line_Style2, yAxis_Line_Style3, yAxis_Line_Style4};
            g2dAxesStroke = new BasicStroke(yAxis_Line_Size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, yAxis_Line_Style, 0);
            line2dAxes.setStroke(g2dAxesStroke);
            line2dAxes.setColor(yAxis_Line_Color);
            line2dAxes.draw(new Line2D.Float(plot_Box_Padding1, plot_Box_Padding2, plot_Box_Padding1, height - plot_Box_Padding4));
        }

    }

    protected void getScale() {
        //Find minimum and maximum data values
        float[] xyMinMax;
        if (xAxis_Auto) {
            xAxis_Min = Integer.MAX_VALUE;
            xAxis_Max = Integer.MIN_VALUE;
            for (int i = 0; i < xyData.size(); i++) {
                xyMinMax = (float[]) xyData.get(i);

                if (xyMinMax[0] < xAxis_Min) {
                    xAxis_Min = xyMinMax[0];
                }

                if (xyMinMax[0] > xAxis_Max) {
                    xAxis_Max = xyMinMax[0];
                }
            }

            //Default 10x10 grid lines
            //xAxis_Grid_Spacing = (xAxis_Max - xAxis_Min) / 10;
        }

        if (yAxis_Auto) {
            yAxis_Min = Integer.MAX_VALUE;
            yAxis_Max = Integer.MIN_VALUE;

            for (int i = 0; i < xyData.size(); i++) {
                xyMinMax = (float[]) xyData.get(i);

                if (xyMinMax[1] < yAxis_Min) {
                    yAxis_Min = xyMinMax[1];
                }

                if (xyMinMax[1] > yAxis_Max) {
                    yAxis_Max = xyMinMax[1];
                }
            }

            //Default 10x10 grid lines
            //yAxis_Grid_Spacing = (yAxis_Max - yAxis_Min) / 10;
        }

        // calculate scale factors for x and y axes
        if (yAxis_Max == yAxis_Min) {
            yScale = (float) (height - plot_Box_Padding2 - plot_Box_Padding4);
        }
        else {
            yScale = (float) (height - plot_Box_Padding2 - plot_Box_Padding4) / (yAxis_Max - yAxis_Min);
        }

        if (xAxis_Max == xAxis_Min) {
            xScale = (float) (width - plot_Box_Padding1 - plot_Box_Padding3);
        }
        else {
            xScale = (float) (width - plot_Box_Padding1 - plot_Box_Padding3) / (xAxis_Max - xAxis_Min);
        }

    }

    /**
     * Draw grid with given grid line spacing
     * @param g
     */
    protected void drawGridEvery(Graphics g) {

        //Draw yAxis Grid
        if (yAxis_Grid_On) {
            Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D

            // draw 2D line using stroke
            float[] xAxis_Grid_Style = {yAxis_Grid_Style1, yAxis_Grid_Style2, yAxis_Grid_Style3, yAxis_Grid_Style4};
            BasicStroke g2dStroke = new BasicStroke(yAxis_Grid_Size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, xAxis_Grid_Style, 0);
            g2d.setStroke(g2dStroke);
            g2d.setColor(yAxis_Grid_Color);

            //Draw Rows
            int totalRowHeight = height - plot_Box_Padding2 - plot_Box_Padding4;
            int gridRowEvery = (int) (yScale * yAxis_Grid_Spacing);

            int rowNos;
            if (gridRowEvery == 0) {
                rowNos = (int) totalRowHeight;
            }
            else {
                rowNos = (int) totalRowHeight / gridRowEvery;
            }

            if (plot_Box_On) {
                rowNos = rowNos - 1;
            }

            for (int i = 1; i <= rowNos; i++) {
                g2d.drawLine(plot_Box_Padding1, height - (plot_Box_Padding4 + i * gridRowEvery), width - plot_Box_Padding3, height - (plot_Box_Padding4 + i * gridRowEvery));
            }

        }

        //Draw xAxis Grid
        if (xAxis_Grid_On) {
            Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D

            // draw 2D line using stroke
            float[] yAxis_Grid_Style = {xAxis_Grid_Style1, xAxis_Grid_Style2, xAxis_Grid_Style3, xAxis_Grid_Style4};
            BasicStroke g2dStroke = new BasicStroke(xAxis_Grid_Size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, yAxis_Grid_Style, 0);
            g2d.setStroke(g2dStroke);
            g2d.setColor(xAxis_Grid_Color);

            //Draw Columns
            int totalColWidth = width - plot_Box_Padding1 - plot_Box_Padding3;
            int gridColEvery = (int) (xScale * xAxis_Grid_Spacing);

            int colNos;

            if (gridColEvery == 0) {
                colNos = (int) totalColWidth;
            }
            else {
                colNos = (int) totalColWidth / gridColEvery;
            }

            if (plot_Box_On) {
                colNos = colNos - 1;
            }

            for (int i = 1; i <= colNos; i++) {
                g2d.drawLine(plot_Box_Padding1 + i * gridColEvery, plot_Box_Padding1, plot_Box_Padding1 + i * gridColEvery, height - plot_Box_Padding4);
            }
        }
    }

    protected void plotData(Graphics g) {
        //Plot xy Data
        Graphics2D line2d = (Graphics2D) g;
        //line2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        float[] plot_Line_Style = {plot_Line_Style1, plot_Line_Style2, plot_Line_Style3, plot_Line_Style4};
        BasicStroke line2dStroke = new BasicStroke(plot_Line_Size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, plot_Line_Style, 0);

        Point last = new Point();
        int x, y;

        for (int i = 0; i < xyData.size(); i++) {
            line2d.setColor(plot_Line_Color);
            line2d.setStroke(line2dStroke);

            float[] xy = (float[]) xyData.get(i);
            x = plot_Box_Padding1 + (int) (xScale * (xy[0] - xAxis_Min));
            y = height - plot_Box_Padding4 - (int) (yScale * (xy[1] - yAxis_Min));

            if (i > 0 && plot_Line_Type.equalsIgnoreCase("Line")) {
                line2d.draw(new Line2D.Float(last.x, last.y, x, y));
            }

            if (i > 0 && plot_Line_Type.equalsIgnoreCase("Stair")) {
                line2d.draw(new Line2D.Float(last.x, last.y, x, last.y));
                line2d.draw(new Line2D.Float(x, last.y, x, y));
            }

            last.x = x;
            last.y = y;

            if (plot_Marker_On) {
                // Stroke with a solid color.
                //line2d.setStroke(new BasicStroke(plot_Marker_Thickness));
                //float[] plot_Marker_Style = {plot_Marker_Style1, plot_Marker_Style2, plot_Marker_Style3, plot_Marker_Style4};

                if (plot_Marker_Style1 == 0 & plot_Marker_Style2 == 0) {
                    plot_Marker_Style1 = 0.01f;
                    plot_Marker_Style2 = 0.01f;
                }
                float[] plot_Marker_Style = {plot_Marker_Style1, plot_Marker_Style2};
                BasicStroke marker2dStroke = new BasicStroke(plot_Marker_Thickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 1.0f, plot_Marker_Style, 0);
                line2d.setStroke(marker2dStroke);

                if (plot_Marker_Type.equalsIgnoreCase("Circle")) {
                    // Create an ellipse shape object
                    Ellipse2D shapeO = new Ellipse2D.Float(x - plot_Marker_Size / 2, y - plot_Marker_Size / 2, plot_Marker_Size, plot_Marker_Size);

                    line2d.setPaint(plot_Marker_Color);
                    line2d.draw(shapeO);

                    // Change the paint and fill the shape.
                    line2d.setPaint(plot_Marker_FillColor);
                    line2d.fill(shapeO);
                }

                if (plot_Marker_Type.equalsIgnoreCase("Square")) {
                    // Create an ellipse shape object
                    Rectangle2D shapeS = new Rectangle2D.Float(x - plot_Marker_Size / 2, y - plot_Marker_Size / 2, plot_Marker_Size, plot_Marker_Size);
                    // Stroke with a solid color.
                    //line2d.setStroke(new BasicStroke(markerLineThickness));
                    // line2d.setStroke(marker2dStroke);

                    line2d.setPaint(plot_Marker_Color);
                    line2d.draw(shapeS);

                    // Change the paint and fill the shape.
                    line2d.setPaint(plot_Marker_FillColor);
                    line2d.fill(shapeS);
                }
            }
        }


    }

    protected void drawTitle(Graphics g) {

        Font titleFont = new Font(plot_Title_Font, Font.PLAIN, plot_Title_FontSize);
        g.setFont(titleFont);
        g.setColor(plot_Title_Color);

        int xTitleLocation = plot_Box_Padding1 + (int) (xScale * (plot_Title_xAlign - xAxis_Min));
        int yTitleLocation = height - plot_Box_Padding4 - (int) (yScale * (plot_Title_yAlign - yAxis_Min));

        g.drawString(plot_Title_Text, xTitleLocation, yTitleLocation);
    }

    protected void drawXLabel(Graphics g) {

        Font labelFont = new Font(xAxis_Label_Font, Font.PLAIN, xAxis_Label_FontSize);
        g.setFont(labelFont);
        g.setColor(xAxis_Label_Color);

        int xLabelLocation = plot_Box_Padding1 + (int) (xScale * (xAxis_Label_xAlign - xAxis_Min));
        int yLabelLocation = height - plot_Box_Padding4 - (int) (yScale * (xAxis_Label_yAlign - yAxis_Min));

        g.drawString(xAxis_Label_Text, xLabelLocation, yLabelLocation);


        //Draw xAxis TickMarks
        if (xAxis_TickMarks_On) {
            Graphics2D g2dTick = (Graphics2D) g; // cast g to Graphics2D

            BasicStroke g2dTickStroke = new BasicStroke(xAxis_TickMarks_Size);
            g2dTick.setStroke(g2dTickStroke);
            g2dTick.setColor(xAxis_TickMarks_Color);

            //Draw Columns
            int totalColWidth = width - plot_Box_Padding1 - plot_Box_Padding3;
            int gridColEvery = (int) (xScale * xAxis_TickMarks_Spacing);

            int colNos;

            if (gridColEvery == 0) {
                colNos = (int) totalColWidth;
            }
            else {
                colNos = (int) totalColWidth / gridColEvery;
            }

            if (plot_Box_On) {
                colNos = colNos - 1;
            }

            //int y1 = height - plot_Box_Padding4 - (int) (yScale * (0 - yAxis_Min));
            int y1 = height - plot_Box_Padding4;
            //int y2 = height - plot_Box_Padding4 - (int) (yScale * (xAxis_TickMarks_Length / yScale - yAxis_Min));
            int y2 = height - plot_Box_Padding4 - (int) (xAxis_TickMarks_Length);

            for (int i = 1; i <= colNos; i++) {
                g2dTick.drawLine(plot_Box_Padding1 + i * gridColEvery, y1, plot_Box_Padding1 + i * gridColEvery, y2);
            }
        }

        //Draw yAxis TickMarks
        if (yAxis_TickMarks_On) {
            Graphics2D g2dTick = (Graphics2D) g; // cast g to Graphics2D

            BasicStroke g2dTickStroke = new BasicStroke(yAxis_TickMarks_Size);
            g2dTick.setStroke(g2dTickStroke);
            g2dTick.setColor(yAxis_TickMarks_Color);


            //Draw Rows
            int totalRowHeight = height - plot_Box_Padding2 - plot_Box_Padding4;
            int gridRowEvery = (int) (yScale * yAxis_TickMarks_Spacing);

            int rowNos;
            if (gridRowEvery == 0) {
                rowNos = (int) totalRowHeight;
            }
            else {
                rowNos = (int) totalRowHeight / gridRowEvery;
            }

            if (plot_Box_On) {
                rowNos = rowNos - 1;
            }

            for (int i = 1; i <= rowNos; i++) {
                g2dTick.drawLine(plot_Box_Padding1, height - (plot_Box_Padding4 + i * gridRowEvery), (int) (plot_Box_Padding1 + yAxis_TickMarks_Length), height - (plot_Box_Padding4 + i * gridRowEvery));
            }
        }

        //Draw xAxis TickLabels
        if (xAxis_TickLabel_On) {

            Font tickLabelFont = new Font(xAxis_TickLabel_Font, Font.PLAIN, xAxis_TickLabel_FontSize);
            g.setFont(tickLabelFont);
            g.setColor(xAxis_TickLabel_Color);

            //Draw Columns
            int totalColWidth = width - plot_Box_Padding1 - plot_Box_Padding3;

            int gridColEvery = (int) (xScale * (xAxis_TickLabel_Spacing));

            int colNos;

            if (gridColEvery == 0) {
                colNos = (int) totalColWidth;
            }
            else {
                colNos = (int) totalColWidth / gridColEvery;
            }

            //int y1 = height - plot_Box_Padding4 - (int) (yScale * (xAxis_TickLabel_yAlign / yScale - yAxis_Min - 15 / yScale));
            int y1 = height - plot_Box_Padding4 - (int) (yScale * (xAxis_TickLabel_yAlign / yScale)) + 15;
            //int y1 = height - plot_Box_Padding4;

            String xLabel;
            for (int i = 0; i <= colNos; i++) {

                xLabel = String.valueOf(xAxis_Min + i * xAxis_TickLabel_Spacing);
                g.drawString(xLabel, (int) (plot_Box_Padding1 + i * gridColEvery + xAxis_TickLabel_xAlign), y1);
            }
        }

        //Draw yAxis TickLabels
        if (yAxis_TickLabel_On) {

            Font tickLabelFont = new Font(yAxis_TickLabel_Font, Font.PLAIN, yAxis_TickLabel_FontSize);
            g.setFont(tickLabelFont);
            g.setColor(yAxis_TickLabel_Color);

            //Draw Rows
            int totalRowHeight = height - plot_Box_Padding2 - plot_Box_Padding4;
            int gridRowEvery = (int) (yScale * yAxis_TickLabel_Spacing);

            int rowNos;
            if (gridRowEvery == 0) {
                rowNos = (int) totalRowHeight;
            }
            else {
                rowNos = (int) totalRowHeight / gridRowEvery;
            }

            int y1 = height - plot_Box_Padding4 - (int) (yScale * (xAxis_TickLabel_yAlign / yScale - yAxis_Min - 15 / yScale));

            String yLabel;

            int x1 = (int) (plot_Box_Padding1 + yAxis_TickLabel_xAlign - 20);
            for (int i = 0; i <= rowNos; i++) {
                yLabel = String.valueOf(yAxis_Min + i * yAxis_TickLabel_Spacing);
                g.drawString(yLabel, x1, (int) (height - plot_Box_Padding4 - i * gridRowEvery + yAxis_TickLabel_yAlign));
            }
        }
    }

    protected void drawYLabel(Graphics g) {
        Graphics2D g2d_Label = (Graphics2D) g;

        Font labelFont = new Font(yAxis_Label_Font, Font.PLAIN, yAxis_Label_FontSize);
        g2d_Label.setFont(labelFont);
        g2d_Label.setColor(yAxis_Label_Color);

        g2d_Label.rotate(-Math.PI / 2, 0, 0);

        int yLabelLocationX = (int) (height - (int) (yScale * (yAxis_Label_yAlign - yAxis_Min)));
        int yLabelLocationY = (int) (plot_Box_Padding2 + (int) (yScale * (yAxis_Label_xAlign - yAxis_Min)));

        g2d_Label.drawString(yAxis_Label_Text, -yLabelLocationX, yLabelLocationY);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paintComponent

        height = this.getHeight();
        width = this.getWidth();
        this.setBackground(plot_Background_Color);

        drawAxes(g);
        if (xyData != null) {
            getScale();
            drawGridEvery(g);
            plotData(g);
            drawTitle(g);
            drawXLabel(g);
            drawYLabel(g);
        }

    }

    public void dynamicPlot(List updateData) {
        xyData = updateData;
        getScale();
        repaint();

    }

    //Plot
    public void setPlotTitle_Text(String textGiven) {
        plot_Title_Text = textGiven;
    }

    public void setPlotTitle_Color(Color colorGiven) {
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

    public void setPlot_Line_Type(String typeGiven) {
        plot_Line_Type = typeGiven;
    }

    public void setPlot_Line_Color(Color colorGiven) {
        plot_Line_Color = colorGiven;
    }

    public void setPlot_Background_Color(Color colorGiven) {
        plot_Background_Color = colorGiven;
    }

    public void setPlot_Line_Style(float[] styleGiven) {
        plot_Line_Style1 = styleGiven[0];
        plot_Line_Style2 =
                styleGiven[1];
        plot_Line_Style3 =
                styleGiven[2];
        plot_Line_Style4 =
                styleGiven[3];
    }

    public void setPlot_Marker_On(boolean markerOnGiven) {
        plot_Marker_On = markerOnGiven;
    }

    public void setPlot_Marker_Size(int sizeGiven) {
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

    public void setAxis_Label_xAlign(float xAlignGiven) {
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

    public void setXAxis_Line_Size(int sizeGiven) {
        xAxis_Line_Size = sizeGiven;
    }

    public void setXAxis_Line_Color(Color colorGiven) {
        xAxis_Line_Color = colorGiven;
    }

    public void setXAxis_Line_Style(float[] styleGiven) {
        xAxis_Line_Style1 = styleGiven[0];
        xAxis_Line_Style2 =
                styleGiven[1];
        xAxis_Line_Style3 =
                styleGiven[2];
        xAxis_Line_Style4 =
                styleGiven[3];
    }

    public void setXAxis_Grid_On(boolean gridOnGiven) {
        xAxis_Grid_On = gridOnGiven;
    }

    public void setXAxis_Grid_Color(Color colorGiven) {
        xAxis_Grid_Color = colorGiven;
    }

    public void setXAxis_Grid_Size(int sizeGiven) {
        xAxis_Grid_Size = sizeGiven;
    }

    public void setXAxis_Grid_Spacing(float spacingGiven) {
        xAxis_Grid_Spacing = spacingGiven;
    }

    public void setXAxis_Grid_Style(float[] styleGiven) {
        xAxis_Grid_Style1 = styleGiven[0];
        xAxis_Grid_Style2 =
                styleGiven[1];
        xAxis_Grid_Style3 =
                styleGiven[2];
        xAxis_Grid_Style4 =
                styleGiven[3];
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

    public void setYAxis_Limits(float xMinGiven, float xMaxGiven) {
        yAxis_Min = xMinGiven;
        yAxis_Max =
                xMaxGiven;
    }

    public void setYAxis_Min(float yMinGiven) {
        yAxis_Min = yMinGiven;
    }

    public void setYAxis_Max(float yMaxGiven) {
        yAxis_Max = yMaxGiven;
    }

    public void setYAxis_Line_Size(int sizeGiven) {
        yAxis_Line_Size = sizeGiven;
    }

    public void setYAxis_Line_Color(Color colorGiven) {
        yAxis_Line_Color = colorGiven;
    }

    public void setYAxis_Line_Style(float[] styleGiven) {
        yAxis_Line_Style1 = styleGiven[0];
        yAxis_Line_Style2 =
                styleGiven[1];
        yAxis_Line_Style3 =
                styleGiven[2];
        yAxis_Line_Style4 =
                styleGiven[3];
    }

    public void setYAxis_Grid_On(boolean gridOnGiven) {
        yAxis_Grid_On = gridOnGiven;
    }

    public void setYAxis_Grid_Color(Color colorGiven) {
        yAxis_Grid_Color = colorGiven;
    }

    public void setYAxis_Grid_Size(int sizeGiven) {
        yAxis_Grid_Size = sizeGiven;
    }

    public void setYAxis_Grid_Spacing(float spacingGiven) {
        yAxis_Grid_Spacing = spacingGiven;
    }

    public void setYAxis_Grid_Style(float[] styleGiven) {
        yAxis_Grid_Style1 = styleGiven[0];
        yAxis_Grid_Style2 =
                styleGiven[1];
        yAxis_Grid_Style3 =
                styleGiven[2];
        yAxis_Grid_Style4 =
                styleGiven[3];
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

    public float getPlot_Line_Style1() {
        return plot_Line_Style1;
    }

    public float getPlot_Line_Style2() {
        return plot_Line_Style1;
    }

    public float getPlot_Line_Style3() {
        return plot_Line_Style1;
    }

    public float getPlot_Line_Style4() {
        return plot_Line_Style1;
    }

    public float[] getPlot_Line_Style() {
        float[] plotLineStyle = new float[4];
        plotLineStyle[0] = plot_Line_Style1;
        plotLineStyle[1] = plot_Line_Style2;
        plotLineStyle[2] = plot_Line_Style3;
        plotLineStyle[3] = plot_Line_Style4;
        return plotLineStyle;
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

    public float[] getPlot_Box_Style() {
        float[] plotLineStyle = new float[4];
        plotLineStyle[0] = plot_Box_Style1;
        plotLineStyle[1] = plot_Box_Style2;
        plotLineStyle[2] = plot_Box_Style3;
        plotLineStyle[3] = plot_Box_Style4;
        return plotLineStyle;
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

    public float[] getXAxis_Line_Style() {
        float[] xAxis_Line_Style = new float[4];
        xAxis_Line_Style[0] = xAxis_Line_Style1;
        xAxis_Line_Style[1] = xAxis_Line_Style2;
        xAxis_Line_Style[2] = xAxis_Line_Style3;
        xAxis_Line_Style[3] = xAxis_Line_Style4;
        return xAxis_Line_Style;
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

    public float[] getXAxis_Grid_Style() {
        float[] xAxis_Grid_Style = new float[4];
        xAxis_Grid_Style[0] = xAxis_Grid_Style1;
        xAxis_Grid_Style[1] = xAxis_Grid_Style2;
        xAxis_Grid_Style[2] = xAxis_Grid_Style3;
        xAxis_Grid_Style[3] = xAxis_Grid_Style4;
        return xAxis_Grid_Style;
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

    public Color getXAxis_TickLabel_Color() {
        return xAxis_TickLabel_Color;
    }

    public String getXAxis_TickLabel_Font() {
        return xAxis_TickLabel_Font;
    }

    public int getXAxis_TickLabel_FontSize() {
        return xAxis_TickLabel_FontSize;
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

    public float[] getYAxis_Line_Style() {
        float[] yAxis_Line_Style = new float[4];
        yAxis_Line_Style[0] = yAxis_Line_Style1;
        yAxis_Line_Style[1] = yAxis_Line_Style2;
        yAxis_Line_Style[2] = yAxis_Line_Style3;
        yAxis_Line_Style[3] = yAxis_Line_Style4;
        return yAxis_Line_Style;
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

    public float[] getYAxis_Grid_Style() {
        float[] yAxis_Grid_Style = new float[4];
        yAxis_Grid_Style[0] = yAxis_Grid_Style1;
        yAxis_Grid_Style[1] = yAxis_Grid_Style2;
        yAxis_Grid_Style[2] = yAxis_Grid_Style3;
        yAxis_Grid_Style[3] = yAxis_Grid_Style4;
        return yAxis_Grid_Style;
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

    public Color getYAxis_TickLabel_Color() {
        return yAxis_TickLabel_Color;
    }

    public String getYAxis_TickLabel_Font() {
        return yAxis_TickLabel_Font;
    }

    public int getYAxis_TickLabel_FontSize() {
        return yAxis_TickLabel_FontSize;
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

    public static void main(String[] args) {

        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 600);

        List xyDataGiven = new Vector();
        //xyData.clear();

        for (int i = 0; i < 4; i++) {
            float[] xxx = new float[2];
            xxx[0] = i + 1;
            xxx[1] = i * 10;
            xyDataGiven.add(i, xxx);
        }

        JPanel_Plot myPlot = new JPanel_Plot();
        //myPlot.setDefaultValues();
        myPlot.dynamicPlot(xyDataGiven);
//        myPlot.setXAxis_Auto(false);
//        myPlot.setYAxis_Auto(false);
//        myPlot.setXAxis_Min(1.0f);
//        myPlot.setXAxis_Max(4.0f);
//        myPlot.setYAxis_Min(0.0f);
//        myPlot.setYAxis_Max(30.0f);
//        myPlot.setDefaultValues();
//        myPlot.setXAxis_Auto(false);
//        myPlot.setYAxis_Auto(false);
//        myPlot.setXAxis_Min(1.0f);
//        myPlot.setXAxis_Max(4.0f);
//        myPlot.setYAxis_Min(0.0f);
//        myPlot.setYAxis_Max(30.0f);
//        myPlot.setXAxis_Grid_On(true);
//        myPlot.setXAxis_Grid_Spacing(10.0f);
//        myPlot.setXAxis_Grid_Color(Color.orange);
//        myPlot.setYAxis_Grid_On(true);
//        myPlot.setYAxis_Grid_Spacing(1.0f);
//        myPlot.setYAxis_Grid_Color(Color.BLUE);
//        myPlot.setPlot_Box_On(true);
//        myPlot.setPlot_Box_FillColor(Color.WHITE);
//        myPlot.setPlot_Box_Color(Color.RED);
//        myPlot.setPlot_Box_Padding(20);
//        myPlot.setXAxis_Grid_Size(1);
//        myPlot.setYAxis_Grid_Size(1);
//        myPlot.setBackground(Color.GRAY);
//        myPlot.setPlot_Box_Size(10.0f);

        myFrame.add(myPlot);

        // myFrame.pack();
        myFrame.setLocation(900, 200);
        myFrame.setVisible(true);




    }
    private int width;
    private int height;
    private float yScale, xScale;

    //Plot Title
    private String plot_Title_Text;
    private Color plot_Title_Color;
    private String plot_Title_Font;
    private int plot_Title_FontSize;
    private float plot_Title_xAlign;
    private float plot_Title_yAlign;

    //Plot Line
    private float plot_Line_Size;
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
    private int plot_Box_Padding1;//West
    private int plot_Box_Padding2;//North
    private int plot_Box_Padding3;//East
    private int plot_Box_Padding4;//South
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

    //yLabel
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

    //Plot Settings
    JDialog_Plot_Settings jd_Plot_Settings;

    //Plot DATA
    private List xyData;
    private String plot_Line_Type;
}
