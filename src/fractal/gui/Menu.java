package fractal.gui;

public class Menu {

    private Menu_Frame menuFrame;
    private NewSurface_Frame newSurfaceFrame;
    private FilDeFer_Frame filDeFerFrame;
    private Strates_Frame stratesFrame;
    private Ombres_Frame ombresFrame;

    public Menu() {
        menuFrame = new Menu_Frame(this);
        newSurfaceFrame = new NewSurface_Frame();
        filDeFerFrame = new FilDeFer_Frame();
        stratesFrame = new Strates_Frame();
        ombresFrame = new Ombres_Frame();
    }

    public void openMenu() {
        menuFrame.pack();
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

    public void openOmbres() {
        ombresFrame.setVisible(true);
    }

}
