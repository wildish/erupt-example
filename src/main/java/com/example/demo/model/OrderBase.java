package com.example.demo.model;

import javax.persistence.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;
import xyz.erupt.upms.handler.DictChoiceFetchHandler;

import java.util.Set;

@Erupt(name = "订单-基本表")
@Table(name = "order_base")
@Entity
public class OrderBase extends BaseModel implements DataProxy<CURDExtension> {

        @EruptField(
                views = @View(
                        title = "订单名称"
                ),
                edit = @Edit(
                        title = "订单名称",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String orderName;

        @EruptField(
                views = @View(
                        title = "客户信息", column = "name"
                ),
                edit = @Edit(
                        title = "客户信息",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private Customer customer;

        @EruptField(
                views = @View(
                        title = "需求说明"
                ),
                edit = @Edit(
                        title = "需求说明",
                        type = EditType.TEXTAREA, search = @Search, notNull = true
                )
        )
        private @Lob String orderDesc;

        @EruptField(
                views = @View(
                        title = "订单状态"
                ),
                edit = @Edit(
                        title = "订单状态",
                        type = EditType.CHOICE, search = @Search, notNull = true,
                        choiceType = @ChoiceType(
                                fetchHandler = DictChoiceFetchHandler.class,
                                fetchHandlerParams = "order_status"
                        )
                )
        )
        private String status;



}