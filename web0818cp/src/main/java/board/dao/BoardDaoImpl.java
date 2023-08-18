package board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDto;
import board.exception.DuplicatedIdException;
import board.util.JdbcUtil;
import board.exception.RecordNotFoundException;

public class BoardDaoImpl implements BoardDao {

@Override
public void add(BoardDto dto) throws SQLException, DuplicatedIdException {
    //DBMS연결
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
        con = JdbcUtil.connect();
        // 3. SQL 작성
        String sql = "INSERT INTO BOARD(NO, WRITER, TITLE, CONTENT, REGDATE)";
        sql += "VALUES( BOARD_SEQ.NEXTVAL , ? , ? , ?, SYSDATE )";
        // 4. Statement 생성
        pstmt = con.prepareStatement(sql);
        // 5. 데이터 설정
        pstmt.setString(1, dto.getWriter());
        pstmt.setString(2, dto.getTitle());
        pstmt.setString(3, dto.getContent());
        // 6. SQL 전송, 결과수신
        int count = pstmt.executeUpdate();
    } catch (Exception e) {
        throw new SQLException(e);
    } finally {
        JdbcUtil.close(pstmt, con);
    }
}

@Override
public void update(BoardDto dto) throws SQLException, RecordNotFoundException {
    //DBMS연결
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
        //등록여부검사
        if( findById(dto.getNo()) == null )
            throw new RecordNotFoundException(dto.getNo()+"는 없습니다");

        con = JdbcUtil.connect();
        // 3. SQL 작성
        String sql = "UPDATE BOARD set title=?, writer=?, content = ?";
        sql += "WHERE no = ?";
        // 4. Statement 생성
        pstmt = con.prepareStatement(sql);
        // 5. 데이터 설정
        pstmt.setString(1, dto.getTitle());
        pstmt.setString(2, dto.getWriter());
        pstmt.setString(3, dto.getContent());
        pstmt.setInt(4, dto.getNo());
        // 6. SQL 전송, 결과수신
        int count = pstmt.executeUpdate();
    } catch (Exception e) {
        throw new SQLException(e);
    } finally {
        JdbcUtil.close(pstmt, con);
    }    
}

@Override
public void delete(int no) throws SQLException, RecordNotFoundException {
    //DBMS연결
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
        //등록여부검사
        if( findById(no) == null )
            throw new RecordNotFoundException(no+"는 없습니다");

        con = JdbcUtil.connect();
        // 3. SQL 작성
        String sql = "DELETE BOARD ";
        sql += "WHERE no = ?";
        // 4. Statement 생성
        pstmt = con.prepareStatement(sql);
        // 5. 데이터 설정
        pstmt.setInt(1, no);
        // 6. SQL 전송, 결과수신
        int count = pstmt.executeUpdate();
    } catch (Exception e) {
        throw new SQLException(e);
    } finally {
        JdbcUtil.close(pstmt, con);
    }    
}

@Override
public int count() throws SQLException {
    int count = 0;
    //DBMS연결
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
        con = JdbcUtil.connect();
        // 3. SQL 작성
        String sql = "SELECT count(*) FROM board ";
        // 4. Statement 생성
        pstmt = con.prepareStatement(sql);
        // 5. 데이터 설정
        // 6. SQL 전송, 결과수신
        //   DML전송: executeUpdate() : int 
        //   SELECT전송: executeQuery() : ResultSet
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        count = rs.getInt(1);
    } catch (Exception e) {
        throw new SQLException(e);
    } finally {
        JdbcUtil.close(pstmt, con);
    }
    return count;
}

@Override
public List<BoardDto> list() throws SQLException {
    List<BoardDto> result = new ArrayList<BoardDto>();
    //DBMS연결
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
        con = JdbcUtil.connect();
        // 3. SQL 작성
        String sql = "SELECT * FROM BOARD order by no DESC";
        // 4. Statement 생성
        pstmt = con.prepareStatement(sql);
        // 5. 데이터 설정
        // 6. SQL 전송, 결과수신
        //   DML전송: executeUpdate() : int 
        //   SELECT전송: executeQuery() : ResultSet
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {//조회결과가 있다
            int no = rs.getInt("no");
            String title = rs.getString("title");
            String writer = rs.getString("writer");
            String content = rs.getString("content");
            Date regdate = rs.getDate("regdate"); 
            BoardDto dto = new BoardDto(no, title, writer, content, regdate);
            result.add(dto);
        }
    } catch (Exception e) {
        throw new SQLException(e);
    } finally {
        JdbcUtil.close(pstmt, con);
    }
    return result;

}

@Override
public BoardDto findById(int no) throws SQLException {
    BoardDto dto = null;
    //DBMS연결
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
        con = JdbcUtil.connect();
        // 3. SQL 작성
        String sql = "SELECT * FROM board where no = ?";
        // 4. Statement 생성
        pstmt = con.prepareStatement(sql);
        // 5. 데이터 설정
        pstmt.setInt(1, no);
        // 6. SQL 전송, 결과수신
        //   DML전송: executeUpdate() : int 
        //   SELECT전송: executeQuery() : ResultSet
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {//조회결과가 있다
            String title = rs.getString("title");
            String writer = rs.getString("writer");
            String content = rs.getString("content");
            Date regdate = rs.getDate("regdate"); 
            dto = new BoardDto(no, title, writer, content, regdate);
        }
    } catch (Exception e) {
        throw new SQLException(e);
    } finally {
        JdbcUtil.close(pstmt, con);
    }
    return dto;
}
}
