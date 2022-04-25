package com.example.demo.model;

import javax.persistence.*;

import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;

import java.util.Set;
import java.util.Date;

@Erupt(name = "客户表")
@Table(name = "customer")
@Entity
public class Customer extends BaseModel {
    @EruptField(
            views = @View(
                    title = "客户名"
            ),
            edit = @Edit(
                    title = "客户名",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;
    @EruptField(
            views = @View(
                    title = "联系电话"
            ),
            edit = @Edit(
                    title = "联系电话",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String phone;
}