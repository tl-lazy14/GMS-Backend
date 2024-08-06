package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.MemberRegistrationTransfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListTransferRegistrationRes {
    private List<MemberRegistrationTransfer> listItem;
    private int numItem;
}
