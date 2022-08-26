package com.hmm.mht.bladevisual.vo;

import com.hmm.mht.bladevisual.model.BladeVisual;
import com.hmm.mht.bladevisual.model.BladeVisualConfig;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hmm
 * @date 2020/9/7 11:19
 * @Description:
 */
@Data
@AllArgsConstructor
public class VisualVO {
    private BladeVisual visual;
    private BladeVisualConfig config;
}
