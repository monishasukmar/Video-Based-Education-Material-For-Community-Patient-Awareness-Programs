Imports MySql.Data.MySqlClient

Public Class WebForm6
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand(String.Format("select * from imgs where ccode='{0}'", Session("selid")), con)
        Dim rs As MySqlDataReader
        rs = com.ExecuteReader
        While rs.Read
            Dim tr As New TableRow
            Dim timg, tdel As New TableCell
            Dim img As New Image
            Dim ldel As New LinkButton
            ldel.Text = "Remove"
            ldel.Attributes.Add("idtorem", rs("idimgs"))
            tdel.Controls.Add(ldel)
            AddHandler ldel.Click, AddressOf delimg
            img.ImageUrl = "Images\" & rs("path")
            img.Width = 300
            img.Height = 300
            timg.Controls.Add(img)
            tr.Cells.Add(timg)
            tr.Cells.Add(tdel)
            Table1.Rows.Add(tr)
        End While
        rs.Close()
        con.Close()
    End Sub

    Protected Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        If FileUpload1.HasFile Then
            FileUpload1.SaveAs(imgPath & "\" & FileUpload1.FileName)
            FileUpload1.SaveAs(Server.MapPath("~\Images\" & FileUpload1.FileName))
            Dim con As New MySqlConnection(constr)
            con.Open()
            Dim com As New MySqlCommand("insert into imgs(ccode, path) values(@ccode, @path);", con)
            With com.Parameters
                .AddWithValue("@ccode", Session("selid"))
                .AddWithValue("@path", FileUpload1.FileName)
            End With
            com.ExecuteNonQuery()
            con.Close()
            Response.Redirect("AddSlide.aspx")
        End If
    End Sub

    Public Sub delimg(sender As Object, e As EventArgs)
        Dim l As LinkButton = sender
        Dim id As Integer = l.Attributes("idtorem")
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand(String.Format("delete from imgs where idimgs='{0}'", id), con)
        com.ExecuteNonQuery()
        con.Close()
        Response.Redirect("AddSlide.aspx")
    End Sub


End Class