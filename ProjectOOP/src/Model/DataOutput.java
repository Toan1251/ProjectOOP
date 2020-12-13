    package ProjectOOP.src.Model;

    import java.util.LinkedList;
    import java.util.List;
    import ProjectOOP.src.Process.*;
    import java.util.ArrayList;
    public class DataOutput extends DataTagging {
        private List<String> sentences;
        // Todo: Thêm các hàm hoặc các lớp cần thiết để tạo, thêm, xóa, trả về câu thích hợp vào LinkedList

        public DataOutput() {
            this.sentences = new LinkedList<String>();
        }

        public DataOutput(DataInput data) {
            super(data);
            this.sentences = new LinkedList<String>();
        }

        public DataOutput(DataInput data, TagManager tags) {
            super(data, tags);
            this.sentences = new LinkedList<String>();
        }

        public DataOutput(DataInput data, List<String> sentences) {
            super(data);
            this.sentences = sentences;
        }

        public DataOutput(DataInput data, TagManager tags, List<String> sentences) {
            super(data, tags);
            this.sentences = sentences;
        }

        public List<String> getSentences() {
            return sentences;
        }

        public void setSentences(List<String> sentences) {
            this.sentences = sentences;
        }

        public void addSentences(String sentence) {
            this.sentences.add(sentence);
        }

        public void addSentences(List<String> sentences) {
            this.sentences.addAll(sentences);
        }

        //Debug
        public void Debug() {
            getData().Debug();
            getTags().Debug();
            for (String sentence : sentences) {
                System.out.println(sentence);
            }
        }

        //public void addGeneralSentences(String arr) {
           // this.sentences.add(arr);
        //}

    //    //day la 1 list chua cac doi tuong Group
    //    public  List<Group> groupList(){
    //        List<Group> list = new ArrayList<>();
    //        list.add(new GroupChangeNumber());
    //        list.add(new GroupDecrease());
    //        list.add(new GroupDecreasePercent());
    //        list.add(new GroupIncrease());
    //        list.add(new GroupIncreasePercent());
    //        list.add(new GroupPersonal());
    //        list.add(new GroupTopAirline());
    //        list.add(new GroupTopAirlineVol());
    //        list.add(new GroupTopBank());
    //        list.add(new GroupTopBankVol());
    //        list.add(new GroupTopFishery());
    //        list.add(new GroupTopFisheryVol());
    //        list.add(new GroupTopPetrol());
    //        list.add(new GroupTopPetrolVol());
    //        list.add(new GroupTopRubber());
    //        list.add(new GroupTopRubberVol());
    //        list.add(new GroupTopSteel());
    //        list.add(new GroupTopSteelVol());
    //        list.add(new GroupTopVolume());
    //        list.add(new GroupVin());
    //
    //        return list;
    //
    //    }

        //Dựa theo tag nhập vào, thêm câu vào
        //về tên tag và type mới chỉ là tạm thời ***
        //***name ở đây là tên của đối tượng cần in ra đoạn văn riêng
        public void makeOutput(Tag tag,ArrayList<DataInput> data) {
            //List<Group> choosenGroupList = new ArrayList<>();
            //for (Tag tag : Tags) {
            if (tag.getTagName().equals("GroupChangeNumber")) {
                addSentences(new GroupChangeNumber().begin(data));
            }
            if (tag.getTagName().equals("GroupDecrease")) {
                addSentences(new GroupDecrease().begin(data));
            }
            if (tag.getTagName().equals("GroupDecreasePercent")) {
                addSentences(new GroupDecreasePercent().begin(data));
            }
            if (tag.getTagName().equals("GroupIncrease")) {
                addSentences(new GroupIncrease().begin(data));
            }
            if (tag.getTagName().equals("GroupIncreasePercent")) {
                addSentences(new GroupIncreasePercent().begin(data));
            }
            if (tag.getTagName().equals("GroupPersonal")) {
                addSentences(new GroupPersonal().begin(data));
            }
            if (tag.getTagName().equals("GroupTopAirline")) {
                addSentences(new GroupTopAirline().begin(data));
            }
            if (tag.getTagName().equals("GroupTopAirlineVol")) {
                addSentences(new GroupTopAirlineVol().begin(data));
            }
            if (tag.getTagName().equals("GroupTopBank")) {
                addSentences(new GroupTopBank().begin(data));
            }
            if (tag.getTagName().equals("GroupTopBankVol")) {
                addSentences(new GroupTopBankVol().begin(data));
            }
            if (tag.getTagName().equals("GroupTopFishery")) {
                addSentences(new GroupTopFishery().begin(data));
            }
            if (tag.getTagName().equals("GroupTopFisheryVol")) {
                addSentences(new GroupTopFisheryVol().begin(data));
            }
            if (tag.getTagName().equals("GroupTopPetrol")) {
                addSentences(new GroupTopPetrol().begin(data));
            }
            if (tag.getTagName().equals("GroupTopPetrolVol")) {
                addSentences(new GroupTopPetrolVol().begin(data));
            }
            if (tag.getTagName().equals("GroupTopRubber")) {
                addSentences(new GroupTopRubber().begin(data));
            }
            if (tag.getTagName().equals("GroupTopRubberVol")) {
                addSentences(new GroupTopRubberVol().begin(data));
            }
            if (tag.getTagName().equals("GroupTopSteel")) {
                addSentences(new GroupTopSteel().begin(data));
            }
            if (tag.getTagName().equals("GroupTopSteelVol")) {
                addSentences(new GroupTopSteelVol().begin(data));
            }
            if (tag.getTagName().equals("GroupTopVolume")) {
                addSentences(new GroupTopVolume().begin(data));
            }
            if (tag.getTagName().equals("GroupVin")) {
                addSentences(new GroupVin().begin(data));
            }
        }
        public void makeOutputPersonal(Tag tag,ArrayList<DataInput> data,String name) {

            if (tag.getTagName().equals("GroupPerSonal")) {

                addSentences(new GroupPersonal().Process(data, name));
            }
        }

            //}

    }