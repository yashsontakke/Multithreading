package LLD.designpatterns.mementodesignpattern;
import java.util.Stack;

// Memento: Stores the state of the document
class DocumentMemento {

    String content ;

    DocumentMemento(String content){
        this.content= content;
    }

    String getContent(){
        return  content;
    }
}

// Originator: Represents the document editor
class DocumentEditor{
    String content = new String();

    void write(String data){
        this.content+= data+" " ;
    }

    DocumentMemento save(){
        return  new DocumentMemento(content);
    }

    String getContent(){
        return  content;
    }

    void setContent(DocumentMemento documentMemento){
        this.content = documentMemento.getContent();
    }

}

// Caretaker: Maintains the history of saved versions
class History{
    Stack<DocumentMemento> contentHistory = new Stack<>();

    void save(DocumentEditor editor){
        contentHistory.push(editor.save());
    }
    void undo(DocumentEditor editor){
        editor.setContent(contentHistory.pop());
    }
}

public class MementoDesignPatternExample {
    public static void main(String[] args) {
        DocumentEditor documentEditor = new DocumentEditor();
        documentEditor.write("abc");
        documentEditor.write("def");
        History history = new History();
        history.save(documentEditor);
        System.out.println(documentEditor.getContent());
        documentEditor.write("ghi");
        history.undo(documentEditor);
        System.out.println(documentEditor.getContent());
    }
}
