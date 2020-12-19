package ProjectOOP.src.Model.Handle;

import java.util.LinkedList;
import java.util.List;
import ProjectOOP.src.Model.Process.*;
    public class DataOutput extends DataTagging {
        private List<String> sentence_name;
        private List<String> sentence_ranking;
        private List<String> sentence_nganh;
        private List<String> sentence_count;
        // Todo: Thêm các hàm hoặc các lớp cần thiết để tạo, thêm, xóa, trả về câu thích hợp vào LinkedList

        public DataOutput() {

            this.sentence_name = new LinkedList<>();
            this.sentence_ranking = new LinkedList<>();
            this.sentence_nganh = new LinkedList<>();
            this.sentence_count = new LinkedList<>();

        }

        public DataOutput(DataInput data) {
            super(data);
            this.sentence_name = new LinkedList<>();
            this.sentence_ranking = new LinkedList<>();
            this.sentence_nganh = new LinkedList<>();
            this.sentence_count = new LinkedList<>();

        }

        public DataOutput(DataInput data, TagManager tags) {
            super(data, tags);
            this.sentence_name = new LinkedList<>();
            this.sentence_ranking = new LinkedList<>();
            this.sentence_nganh = new LinkedList<>();
            this.sentence_count = new LinkedList<>();

        }

//        public DataOutput(DataInput data, List<String> sentences) {
//            super(data);
//            this.sentence = sentences;
//        }
//
//        public DataOutput(DataInput data, TagManager tags, List<String> sentences) {
//            super(data, tags);
//            this.sentences = sentences;
//        }

        public List<String> getSentence_name() {
            return sentence_name;
        }

        public List<String> getSentence_ranking() {
            return sentence_ranking;
        }

        public List<String> getSentence_nganh() {
            return sentence_nganh;
        }

        public List<String> getSentence_count(){return sentence_count;}

        public void addSentence_name(String sentence) {
            this.sentence_name.add(sentence);
        }

        public void addSentences_name(List<String> sentences) {
            this.sentence_name.addAll(sentences);
        }

        public void addSentence_ranking(String sentence) {
            this.sentence_ranking.add(sentence);
        }

        public void addSentences_ranking(List<String> sentences) {
            this.sentence_ranking.addAll(sentences);
        }

        public void addSentence_nganh(String sentence) {
            this.sentence_nganh.add(sentence);
        }

        public void addSentences_nganh(List<String> sentences) {
            this.sentence_nganh.addAll(sentences);
        }

        public void addSentence_count(String sentence) {
            this.sentence_count.add(sentence);
        }

        public void addSentences_count(List<String> sentences) {
            this.sentence_count.addAll(sentences);
        }


//        //Debug
//        public void Debug() {
//            getData().Debug();
//            getTags().Debug();
//            for (String sentence : sentences) {
//                System.out.println(sentence);
//            }
//        }

    }