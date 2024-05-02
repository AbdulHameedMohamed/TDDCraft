package unit.iti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameInverter {
    public String invertName(String name) {
        if(name == null || name.length() == 0)
            return "";
        return formatName(removeHonorific(splitNames(name)));
    }

    private String formatName(List<String> names) {
        if(names.size() == 1)
            return names.get(0);
        else
            return formatMultiElementName(names);
    }

    private String formatMultiElementName(List<String> names) {
        String postNominals = getPostNominals(names);
        String firstName = names.get(0);
        String lastName = names.get(1);
        return String.format("%s, %s %s", lastName, firstName, postNominals).trim();
    }

    private String getPostNominals(List<String> names) {
        String postNominals= "";
        if (names.size()> 2) {
            List<String> postNominalsList = names.subList(2, names.size());
            String postNominal = "";
            for (String pn: postNominalsList)
                postNominal+= pn + " ";
            postNominals = postNominal;
        }
        return postNominals;
    }

    private List<String> removeHonorific(List<String> names) {
        if(isHonorific(names))
            names.remove(0);
        return names;
    }

    private boolean isHonorific(List<String> names) {
        return names.get(0).matches("Mr\\.|Mrs\\.");
    }

    private ArrayList<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }
}