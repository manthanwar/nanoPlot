package nanoplot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FloatDataFileReader {

    public List coords;

    @SuppressWarnings("unchecked")
    public FloatDataFileReader(String fileName) {
        coords = new ArrayList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                float x = Float.parseFloat(data[0]);
                float y = Float.parseFloat(data[1]);
                coords.add(new float[]{x, y});

            }
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public List getData() {
        return coords;
    }
}