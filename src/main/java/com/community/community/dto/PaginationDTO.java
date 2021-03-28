package com.community.community.dto;

import com.community.community.model.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;//是否展示向前的标记
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();//当前页面展示的page列表
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        totalPage = (int) Math.ceil((double)totalCount/size); //计算总页数，上取整,函数中参数要转换成double，不然会自动得到下取整的int

        //确定当前该展示哪几个分页
        if(page<1)page=1;
        if(page>totalPage)page=totalPage;

        this.page=page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页
        if(page == 1){
            showPrevious=false;
        }
        else {
            showPrevious=true;
        }


        //是否展示下一页
        if(page==totalPage){
            showNext=false;
        }
        else{
            showNext=true;
        }
        // 是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        // 是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
