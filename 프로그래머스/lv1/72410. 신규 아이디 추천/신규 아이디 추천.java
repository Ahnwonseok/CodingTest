
class Solution {
    public String solution(String new_id) {
        String answer = "";
        String regex = "[^a-z0-9-_.]";

        new_id = new_id.toLowerCase();
        System.out.println(new_id);

        new_id = new_id.replaceAll(regex,"");
        System.out.println(new_id);

        new_id = new_id.replaceAll("[..]+",".");
        System.out.println(new_id);

        if (new_id.charAt(0) == 46) {
            new_id = new_id.replaceAll("^[.]", "");
            System.out.println(new_id);
        }
        if ((new_id.length()>0) && (new_id.charAt(new_id.length()-1) == 46) ) {
            new_id = new_id.replaceAll("[.]$", "");
            System.out.println(new_id);
        }
        if (new_id.length()==0) new_id="a";

        if (new_id.length() > 15) {
            new_id = new_id.substring(0,15);
            if( new_id.substring(new_id.length()-1).equals(".") ) new_id = new_id.substring(0,14);
        }

        if(new_id.length()<3) {
            String add = new_id.substring(new_id.length()-1);
            while (new_id.length()!=3)
                new_id += add;
        }

        System.out.println(new_id);
        return new_id;
    }
}