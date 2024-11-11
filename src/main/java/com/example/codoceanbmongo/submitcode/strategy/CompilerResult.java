package com.example.codoceanbmongo.submitcode.strategy;

import com.example.codoceanbmongo.submitcode.ECompilerConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompilerResult {
    private ECompilerConstants compilerConstants;
    private String error;

    public CompilerResult(ECompilerConstants compilerConstants) {
        this.compilerConstants = compilerConstants;
    }
}
