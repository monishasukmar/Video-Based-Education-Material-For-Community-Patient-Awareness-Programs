Imports MySql.Data.MySqlClient

Public Class WebForm11
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Dim dt As String = Session("dtsel")
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand(String.Format("SELECT * FROM app.scores where dt in (select dt from scores where id= '{0}') and coursecode='{1}';", dt, Session("selid")), con)
        Dim rs As MySqlDataReader
        rs = com.ExecuteReader
        Dim sno As Integer = 1
        While rs.Read
            Dim tr As New TableRow
            Dim tsno, tname, tphno, tpres, tposts As New TableCell
            tsno.Text = sno
            tname.Text = rs("patientname")
            tphno.Text = rs("patientphone")
            tpres.Text = rs("prescore")
            tposts.Text = rs("postscore")
            tsno.Attributes.Add("class", "tdcenter")
            tname.Attributes.Add("class", "tdnormal")
            tphno.Attributes.Add("class", "tdnormal")
            tpres.Attributes.Add("class", "tdcenter")
            tposts.Attributes.Add("class", "tdcenter")
            tr.Cells.Add(tsno)
            tr.Cells.Add(tname)
            tr.Cells.Add(tphno)
            tr.Cells.Add(tpres)
            tr.Cells.Add(tposts)
            Table1.Rows.Add(tr)
            sno = sno + 1
        End While
        rs.Close()
        con.Close()
    End Sub

End Class