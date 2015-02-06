package cz.mrPizzaCake.quadria;
/*
 * Copyright 2015 Vojtěch "MrPizzaCake" Trefný
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

import org.lwjgl.glfw.GLFWErrorCallback;

import java.io.File;

import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;
import static org.lwjgl.glfw.Callbacks.glfwSetCallback;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Main
{
	static
	{
		System.setProperty("org.lwjgl.librarypath",
							new File("binaries/libraries/LWJGL/lwjgl/native/").getAbsolutePath());
	}
	public static void main(String... args)
	{
		GLFWErrorCallback errorCallback;
		glfwSetCallback(errorCallback = errorCallbackPrint(System.err));
		
		if (glfwInit() != GL_TRUE)
			throw new RuntimeException("GLFW couldn't be initialized");
		
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
		
		long id = glfwCreateWindow(300, 300, "Boom", NULL, NULL);
		
		glfwShowWindow(id);
		
		while (glfwWindowShouldClose(id) != GL_TRUE)
		{
			glfwPollEvents();
		}
		
		glfwDestroyWindow(id);
		
		errorCallback.release();
		
		glfwTerminate();
	}
}
