package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.MemberRegistrationTransfer;
import com.example.gms_backend.entity.TrialRegistration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListTrialRegistrationRes {
    private List<TrialRegistration> listItem;
    private int numItem;
}
