package net.minecraft.src;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ShaderPackFolder implements IShaderPack
{
    protected File packFile;

    public ShaderPackFolder(String var1, File var2)
    {
        this.packFile = var2;
    }

    public void close() {}

    public InputStream getResourceAsStream(String var1)
    {
        try
        {
            File var2 = new File(this.packFile, var1.substring(1));

            if (var2 != null)
            {
                return new BufferedInputStream(new FileInputStream(var2));
            }
        }
        catch (Exception var3)
        {
            ;
        }

        return null;
    }
}
