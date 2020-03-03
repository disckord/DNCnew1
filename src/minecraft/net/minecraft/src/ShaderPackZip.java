package net.minecraft.src;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ShaderPackZip implements IShaderPack
{
    protected File packFile;
    protected ZipFile packZipFile;

    public ShaderPackZip(String var1, File var2)
    {
        this.packFile = var2;
        this.packZipFile = null;
    }

    public void close()
    {
        if (this.packZipFile != null)
        {
            try
            {
                this.packZipFile.close();
            }
            catch (Exception var2)
            {
                ;
            }

            this.packZipFile = null;
        }
    }

    public InputStream getResourceAsStream(String var1)
    {
        if (this.packZipFile == null)
        {
            try
            {
                this.packZipFile = new ZipFile(this.packFile);
            }
            catch (Exception var4)
            {
                ;
            }
        }

        if (this.packZipFile != null)
        {
            try
            {
                ZipEntry var2 = this.packZipFile.getEntry(var1.substring(1));

                if (var2 != null)
                {
                    return this.packZipFile.getInputStream(var2);
                }
            }
            catch (Exception var3)
            {
                ;
            }
        }

        return null;
    }
}
