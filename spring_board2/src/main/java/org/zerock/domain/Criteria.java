package org.zerock.domain;

public class Criteria {

  private int page=1;
  private int perPageNum=2;   // 페이지 당 글 갯수

  public Criteria() {
    this.page = 1;
    this.perPageNum = 2;
  }

  public void setPage(int page) {

    if (page <= 0) {
      this.page = page;
      return;
    }

    this.page = page;
  }

  public void setPerPageNum(int perPageNum) {

    if (perPageNum <= 0 || perPageNum > 100) {
      this.perPageNum = 2;
      return;
    }

    this.perPageNum = perPageNum;
  }

  public int getPage() {
    return page;
  }

  // method for MyBatis SQL Mapper -
  public int getPageStart() {     // 시작 데이터 번호

    return (this.page - 1) * perPageNum;
  }

  // method for MyBatis SQL Mapper
  public int getPerPageNum() {

    return this.perPageNum;
  }

  @Override
  public String toString() {
    return "Criteria [page=" + page + ", "
        + "perPageNum=" + perPageNum + "]";
  }
}
