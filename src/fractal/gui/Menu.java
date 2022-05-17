package fractal.gui;

public class Menu {

    private Menu_Frame menuFrame;
    private NewSurface_Frame newSurfaceFrame;
    private FilDeFer_Frame filDeFerFrame;
    private Strates_Frame stratesFrame;

    public Menu() {
        menuFrame = new Menu_Frame(this);
        newSurfaceFrame = new NewSurface_Frame(this);
        filDeFerFrame = new FilDeFer_Frame(this);
        stratesFrame = new Strates_Frame(this);
    }

    public void openMenu() {
        menuFrame.setVisible(true);
    }

    public void openNewSurface() {
        newSurfaceFrame.setVisible(true);
    }

    public void openFilDeFer() {
        filDeFerFrame.setVisible(true);
    }
    
    public void openStrates() {
        stratesFrame.setVisible(true);
    }

}
