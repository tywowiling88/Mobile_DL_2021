package umn.ac.id.week8_33081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class modul8a extends AppCompatActivity {

    RadioGroup rgJenis;
    RadioButton rbTemporary, rbInternal, rbExternal;
    EditText etNamaFile, etText;
    Button btnOpen, btnSave, btnClear, btnDelete, btnExit;

    private File tempDir; //cache [method getChaceDir()];
    private File lokalDir; //internal storage [method getFilesDir()];
    private File extDir; //eksternal storage [method getExternalDir()];
    private File curDir; // current atau pilihan storage sesuai dengan radioButton yang dipilih

    private Context context;
    private static PopupMenu pilihFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul8a);

        rgJenis = findViewById(R.id.rgJenis);
        rbTemporary = findViewById(R.id.rbTemporary);
        rbInternal = findViewById(R.id.rbInternal);
        rbExternal = findViewById(R.id.rbExternal);
        etNamaFile = findViewById(R.id.etNamaFile);
        etText = findViewById(R.id.etText);
        btnOpen = findViewById(R.id.btnOpen);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);
        btnDelete = findViewById(R.id.btnDelete);
        btnExit = findViewById(R.id.btnExit);

        keluarApp();

//        Set tempDir to cache dir
        tempDir = getCacheDir();

//        set lokalDir to internal storage
        lokalDir = getFilesDir();

//        Check if gain permission to external storage.
//        if yes set extDir to external storage
//        if no set extDir to null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            extDir = getExternalFilesDir(null);
        } else {
            findViewById(R.id.rbExternal).setEnabled(false);
            extDir = null;
        }

//      set curDir to lokalDir
        curDir = lokalDir;

        getRbChoose();

        clearText();

        saveFile();

        context = modul8a.this;
        pilihFile = new PopupMenu(context, btnOpen);
        pilihFile.getMenuInflater().inflate(R.menu.menu_kosong, pilihFile.getMenu());


        pilihFile.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                etNamaFile.setText(item.getTitle().toString());
                etNamaFile.setText("");
                etText.setText("");
                return true;
            }
        });

        openFile();

        deleteFile();

    }

    private void deleteFile() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaFile = etNamaFile.getText().toString();
                if (namaFile.length() > 0) {
                    boolean sukses = false;
                    if (curDir != null && curDir == lokalDir){
                        sukses = context.deleteFile(namaFile);
                    } else {
                        sukses = new File(curDir, namaFile).delete();
                    }
                    if (sukses) {
                        Toast.makeText(context, "File Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "File Gagal Dihapus", Toast.LENGTH_SHORT).show();
                    }
                    etText.setText("");
                    etNamaFile.setText("");
                } else {
                    Toast.makeText(context, "Nama File Kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void openFile() {
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File[] files = null;

                if (curDir != null) {
                    files = curDir.listFiles();
                }
                if (files != null) {
                    int n = files.length;
                    pilihFile.getMenu().clear();

                    for (int i = 0; i < n; i++){
                        pilihFile.getMenu().add(files[i].getName());
                        pilihFile.show();
                        bacaFile();
                    }
                } else {
                    Toast.makeText(context, "Ada Masalah Akses Folder" + "Atau Folder Masih Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            private void bacaFile() {
                String namaFile = etNamaFile.getText().toString();
                if (namaFile.length() > 0) {
                    File file = new File(curDir, namaFile);
                    String isiFile = "";
                    try {
                        InputStream inStream = new FileInputStream(file);
                        if (inStream != null) {
                            InputStreamReader isReader = new InputStreamReader(inStream);
                            BufferedReader bReader = new BufferedReader(isReader);
                            String terimaString = "";

                            StringBuilder sb = new StringBuilder();
                            while ((terimaString = bReader.readLine()) != null){
                                    sb.append(terimaString).append("\n");
                            }
                            inStream.close();
                            isiFile = sb.toString();
                            etText.setText(isiFile);
                        }
                    } catch (FileNotFoundException e) {
                        Toast.makeText(context, "File Tidak Ditemukan", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        Toast.makeText(context, "Eror ketika Input Output", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    private void saveFile() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nFile = etNamaFile.getText().toString();
                String isiText = etText.getText().toString();

                if (nFile.length() > 0 && isiText.length() > 0 && curDir != null){
                    File file = new File(curDir, nFile);        //set File dengan nama file dari edit text, ke dalam current directory
                    try {
                        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file)); //Untuk menuliskan text ke dalam file
                        writer.write(isiText); //menyimpan isi text
                        writer.close(); //menutup kemudian save isi text dari suatu file.
                        Toast.makeText(modul8a.this, "Text Sudah Terimpan", Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        Toast.makeText(modul8a.this, "File Tidak ditemukan", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        Toast.makeText(modul8a.this, "Terdapat Kesalahan ketika menyimpan isi file", Toast.LENGTH_SHORT).show();
                    }
                }

                if (nFile.length() == 0 || isiText.length() == 0){
                    Toast.makeText(modul8a.this, "Nama File atau Isi File Kosong", Toast.LENGTH_SHORT).show();
                }
//                Toast.makeText(context, ""+ curDir, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void clearText() {
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etText.setText("");
                etNamaFile.setText("");
            }
        });


    }

    private void getRbChoose() {
        rgJenis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String pilihan = ((RadioButton) findViewById(rgJenis.getCheckedRadioButtonId())).getText().toString();

                if (pilihan.equalsIgnoreCase("Temporary")) {
                    curDir = tempDir;
                }
                else if (pilihan.equalsIgnoreCase("Internal")) {
                    curDir = lokalDir;
                }
                else {
                    curDir = extDir;
                }
            }
        });
    }

    private void keluarApp() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // hapus semua file di cache
        File[] tempFiles = tempDir.listFiles();
        for (File tempFile : tempFiles){
            if (tempFile.isFile()){
                tempFile.delete();
            }
        }
    }

}