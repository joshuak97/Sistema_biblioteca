package Camara;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.Thread.UncaughtExceptionHandler;
import javax.swing.JFrame;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * Proof of concept of how to handle webcam video stream from Java
 * 
 * @author Bartosz Firyn (SarXos)
 */
public class MiWebcam extends JFrame implements Runnable, WebcamListener, WindowListener, UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener {

	private static final long serialVersionUID = 1L;
        boolean validar=false;
	private Webcam webcam = null;
	private WebcamPanel panel = null;
	private WebcamPicker picker = null;
        private final JButton btnTomarFoto=new JButton("Tomar Foto");
        String numeroControl;
        Image iconCamara=new ImageIcon(getClass().getResource("/imagenes/camara.png")).getImage();
        
        public MiWebcam(){
            
        }
        
              
	
        @Override
	public void run() {

		Webcam.addDiscoveryListener(this);

		setTitle("Tome una Foto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setLocation(50,50);
		setLayout(new BorderLayout());
                setIconImage(iconCamara);

		addWindowListener(this);

		picker = new WebcamPicker();
		picker.addItemListener(this);

		webcam = picker.getSelectedWebcam();

		if (webcam == null) {
			JOptionPane.showMessageDialog(this,"No se detectan Camaras","ERROR",JOptionPane.ERROR_MESSAGE);
			this.dispose();
		}

		webcam.setViewSize(WebcamResolution.VGA.getSize());
		webcam.addWebcamListener(MiWebcam.this);

		panel = new WebcamPanel(webcam, false);
		panel.setFPSDisplayed(true);

                
		add(picker, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
                btnTomarFoto.addActionListener(this::actionPerformedBtnTomarFoto);
                add(btnTomarFoto,BorderLayout.SOUTH);
                
                
		pack();
		setVisible(true);

		Thread t = new Thread() {

			@Override
			public void run() {
				panel.start();
			}
		};
		t.setName("example-starter");
		t.setDaemon(true);
		t.setUncaughtExceptionHandler(this);
		t.start();
	}


	@Override
	public void webcamOpen(WebcamEvent we) {
        //	System.out.println("webcam open");
	}

	@Override
	public void webcamClosed(WebcamEvent we) {
	//	System.out.println("webcam closed");
	}

	@Override
	public void webcamDisposed(WebcamEvent we) {
	//	System.out.println("webcam disposed");
	}

	@Override
	public void webcamImageObtained(WebcamEvent we) {
		// do nothing
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
		webcam.close();
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("webcam viewer resumed");
		panel.resume();
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("webcam viewer paused");
		panel.pause();
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.err.println(String.format("Exception in thread %s", t.getName()));
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getItem() != webcam) {
			if (webcam != null) {

				panel.stop();

				remove(panel);

				webcam.removeWebcamListener(this);
				webcam.close();

				webcam = (Webcam) e.getItem();
				webcam.setViewSize(WebcamResolution.VGA.getSize());
				webcam.addWebcamListener(this);

				System.out.println("selected " + webcam.getName());

				panel = new WebcamPanel(webcam, false);
				panel.setFPSDisplayed(true);

				add(panel, BorderLayout.CENTER);
				pack();

				Thread t = new Thread() {

					@Override
					public void run() {
						panel.start();
					}
				};
				t.setName("example-stoper");
				t.setDaemon(true);
				t.setUncaughtExceptionHandler(this);
				t.start();
			}
		}
	}

	@Override
	public void webcamFound(WebcamDiscoveryEvent event) {
		if (picker != null) {
			picker.addItem(event.getWebcam());
		}
	}

	@Override
	public void webcamGone(WebcamDiscoveryEvent event) {
		if (picker != null) {
			picker.removeItem(event.getWebcam());
		}
	}

    public void setValidar(boolean validar) {
        this.validar = validar;
    }

   
    public void actionPerformedBtnTomarFoto(ActionEvent evt) {
     
         
     try {
         ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
         BufferedImage image = webcam.getImage();
         File outputfile = new File("C:\\BIBIOTEC\\FotoAlumnos\\"+numeroControl+".jpg");
            // save image to jpg file
             ImageIO.write(image, "JPG",outputfile);
             JOptionPane.showMessageDialog(this, "La image se ha guardado con éxito", "Imagen Guardada",JOptionPane.INFORMATION_MESSAGE, icon);
             validar=true;
             this.dispose();
     } catch (IOException ex) {
             Logger.getLogger(MiWebcam.class.getName()).log(Level.SEVERE, null, ex);
             
     }    
       
     
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public boolean isValidar() {
        return validar;
    }
    
    
    
     
    
    
}
