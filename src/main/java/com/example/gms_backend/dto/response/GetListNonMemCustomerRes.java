package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Equipment;
import com.example.gms_backend.entity.NonMemberCustomer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListNonMemCustomerRes {
    private List<NonMemberCustomer> listItem;
    private int numItem;
}
