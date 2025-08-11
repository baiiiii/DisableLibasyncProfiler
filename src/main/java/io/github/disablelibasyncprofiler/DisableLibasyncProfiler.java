package io.github.disablelibasyncprofiler;

import com.intellij.execution.Executor;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.runners.JavaProgramPatcher;

public class DisableLibasyncProfiler extends JavaProgramPatcher {

    @Override
    public void patchJavaParameters(Executor executor, RunProfile runProfile, JavaParameters javaParameters) {
        // -agentpath:C:\Users\admin\AppData\Local\Temp\idea_libasyncProfiler_dll_temp_folder\libasyncProfiler.dll
        String parameterPrefix = "-agentpath:" + System.getenv("TEMP") + "\\idea_libasyncProfiler_dll_temp_folder";
        javaParameters.getVMParametersList().replaceOrPrepend(parameterPrefix,"");
    }
}
